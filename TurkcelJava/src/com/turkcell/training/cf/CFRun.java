package com.turkcell.training.cf;

import java.util.concurrent.CompletableFuture;

import com.turkcell.training.mt.MyRunnable;

public class CFRun {
	public static void main(String[] args) {
		// CompletableFuture<Void> runAsync = CompletableFuture.runAsync(new MyRunnable(d -> System.out.println(d)));
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()-> {
			try {
				Thread.sleep(2_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "hello world";});
		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// boolean complete = supplyAsync.complete("hello fail");
		String str = supplyAsync.getNow("hello if fail");
		System.out.println(str);
	}
}
