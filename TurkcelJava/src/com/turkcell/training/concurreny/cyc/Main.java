package com.turkcell.training.concurreny.cyc;

import java.util.concurrent.CyclicBarrier;

public class Main {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Barrier finished");
			}
		});
		for (int i = 0; i < 3; i++) {
			MyCycThread cycThread = new MyCycThread(barrier);
			cycThread.start();
		}
	}
}
