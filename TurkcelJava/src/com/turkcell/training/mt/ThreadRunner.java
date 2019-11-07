package com.turkcell.training.mt;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.turkcell.training.mt.thp.MyCallable;

public class ThreadRunner {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			newFixedThreadPool.execute(new MyRunnable((s) -> System.out.println(s)));
		}
		
		Future<String> submit = newFixedThreadPool.submit(new MyCallable());
		// some codes
		String string = submit.get();
		
		
		Thread nThread = new Thread(new MyRunnable((e) -> System.out.println(e)),"runable1");
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
