package com.hcl.threads.ex3_4;

public class DemoThread1 implements Runnable {
	private Thread thread;

	public DemoThread1() {
		// the instructions indicated that DemoThread1 should implement Runnable itself
		// but also spawn threads in its constructor
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.printf("running child Thread %s in loop%n", Thread.currentThread().getName());
				for (int i = 1; i <= 10; i++) {
					System.out.printf("%s: %d%n", Thread.currentThread().getName(), i);
					try {
						Thread.sleep(2_000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("Running thread " + Thread.currentThread().getName());
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
