package com.hcl.threads.ex3_4;

/*
3  	Write a program to create a class DemoThread1 implementing Runnable interface. In the constructor,
create a new thread and start the thread. In run() display a message "running child Thread in loop : "
display the value of the counter ranging from 1 to 10. Within the loop put the thread to sleep for 2 seconds.
In main create 3 objects of the DemoTread1 and execute the program.  
  
4  	Rewrite the earlier program so that, now the class DemoThread1 instead of implementing from Runnable interface,
will now extend from Thread class.  
*/
public class Main {
	public static void main(String[] args) {
		int numThreads = 3;
		Thread[] threads = new Thread[numThreads];

		// using DemoThread1
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new Thread(new DemoThread1());
			threads[i].start();

		}
		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---------------------------------------");
		// using inheritance (DemoThread2)
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new DemoThread2();
			threads[i].start();

		}
		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
