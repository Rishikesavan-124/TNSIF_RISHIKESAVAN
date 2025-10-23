//Program to define ChildThread 
package com.tnsif.multithreading;

public class MyChildThread extends Thread {
	@Override
	public void run() {
		System.out.println("Inside run() Thread is alive or not? " + this.isAlive());
		int no = 0;
		while (no < 4) {
			no++;
			System.out.println("number = " + no);
			try {
				sleep(500);

			} catch (InterruptedException exp) {
				System.err.println("Thread Interrupted ...");
			}
		}
	}
}
