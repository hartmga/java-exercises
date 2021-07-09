package threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Write a program to assign the current thread to t1. Change the name of the thread to MyThread.
Display the changed name of the thread. Also it should display the current time. Put the thread to
sleep for 10 seconds and display the time again.  
*/
public class Exercise1 {

	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		t1.setName("MyThread");
		System.out.println("Current thread name: " + t1.getName());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kk:mm:ss");
		System.out.println("Current time: " + LocalDateTime.now().format(formatter));
		try {
			t1.sleep(10_000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Time after sleeping 10s: " + LocalDateTime.now().format(formatter));

	}

}
