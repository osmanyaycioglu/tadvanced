package com.turkcell.training.mt.thp;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
	
	private BlockingQueue<Runnable> runQueue = new ArrayBlockingQueue<>(1_000);
	
	private int threadCount;
	
	public MyThreadPool(int threadCount) {
		this.threadCount = threadCount;
		for (int i = 0; i < threadCount; i++) {
			MyRunnerThreads myRunnerThreads = new MyRunnerThreads(runQueue);
			myRunnerThreads.start();
		}
	}
	
	public boolean addItem(Runnable runnable) {
		return runQueue.add(runnable);
	}
	
	static class MyRunnerThreads extends Thread {
		private BlockingQueue<Runnable> runQueue;
		public MyRunnerThreads(BlockingQueue<Runnable> runQueue) {
			this.runQueue = runQueue;
		}
		@Override
		public void run() {
			while (true) {
				try {
					Runnable take = runQueue.take();
					runQueue.poll();
					take.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
