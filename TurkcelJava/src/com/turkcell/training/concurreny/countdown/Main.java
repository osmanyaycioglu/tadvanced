package com.turkcell.training.concurreny.countdown;

import java.util.concurrent.CountDownLatch;

public class Main {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			MyCountDownThread countDownThread = new MyCountDownThread(countDownLatch);
			countDownThread.start();
			
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All threads are dead");
		
	}
}
