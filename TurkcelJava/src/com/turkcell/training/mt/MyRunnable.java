package com.turkcell.training.mt;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Baslad�m");
		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
		}
		System.out.println("Bittim");
	}

}
