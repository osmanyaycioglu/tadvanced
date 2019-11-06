package com.turkcell.training.mt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunner {
	public static void main(String[] args) {
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			newFixedThreadPool.execute(new MyRunnable());
		}
		
		Thread nThread = new Thread(new MyRunnable(),"runable1");
		nThread.start();
		
		for (int i = 0; i < 8; i++) {
			MyFirstThread firstThread = new MyFirstThread();
			firstThread.start();
		}

		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
		}
		System.out.println(MyFirstThread.counter);
	}
}
