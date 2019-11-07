package com.turkcell.training.mt;

public class MyRunnable implements Runnable{
	
	private ICallback execute;
	
	public MyRunnable(ICallback execute) {
		this.execute = execute;
	}
	@Override
	public void run() {
		System.out.println("Basladým");
		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
		}
		System.out.println("Bittim");
		execute.callBack("hello world");
	}

}
