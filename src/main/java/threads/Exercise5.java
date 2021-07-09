package threads;

/*
5  	Write a program to create a class Number  which implements Runnable. Run method displays the multiples
of a number accepted as a parameter. In main create three objects - first object should display the multiples
of 2, second should display the multiples of 5 and third should display the multiples of 8. Display appropriate
message at the beginning and ending of thread. The main thread should wait for the first object to complete.
Display the status of threads before the multiples are displayed and after completing the multiples.  
*/
public class Exercise5 {

	public static class Number implements Runnable {

		private int num;
		int times;

		public Number(int num, int times) {
			this.num = num;
			this.times = times;
		}

		@Override
		public void run() {
			System.out.println("Starting thread " + Thread.currentThread().getName());
			int total = 0;
			for (int i = 0; i < times; i++) {
				total += num;
				System.out.println(total);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Completing thread " + Thread.currentThread().getName());

		}

	}

	public static void main(String[] args) {
		int times = 10;
		Thread mult2 = new Thread(new Number(2, times), "mult2");
		Thread mult5 = new Thread(new Number(5, times), "mult5");
		Thread mult8 = new Thread(new Number(8, times), "mult8");
		System.out.printf("%s status: %s%n", mult2.getName(), mult2.getState());
		System.out.printf("%s status: %s%n", mult5.getName(), mult5.getState());
		System.out.printf("%s status: %s%n", mult8.getName(), mult8.getState());

		mult2.start();
		mult5.start();
		mult8.start();
		try {
			mult2.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		try {
			mult5.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		try {
			mult8.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.printf("%s status: %s%n", mult2.getName(), mult2.getState());
		System.out.printf("%s status: %s%n", mult5.getName(), mult5.getState());
		System.out.printf("%s status: %s%n", mult8.getName(), mult8.getState());
		System.out.println("done");
	}

}
