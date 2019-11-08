package com.turkcell.training.concurreny.cyc;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class MyCycThread extends Thread{
	private CyclicBarrier barrier;
	
	
	public MyCycThread(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(new SecureRandom().nextInt(10_000));
			System.out.println("a");
			barrier.await();
			Thread.sleep(new SecureRandom().nextInt(10_000));
			System.out.println("b");
			barrier.await();
			Thread.sleep(new SecureRandom().nextInt(10_000));
			System.out.println("c");
			barrier.await();
			barrier.reset();
		} catch (Exception e) {
		}
	}
}
