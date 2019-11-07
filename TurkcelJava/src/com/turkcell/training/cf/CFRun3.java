package com.turkcell.training.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.turkcell.training.mt.MyRunnable;

public class CFRun3 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			CompletableFuture.supplyAsync(() -> {
				System.out.println("Async : " + Thread.currentThread().getName());
//				try {
//					Thread.sleep(1_000);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
				return "hello world";
			}).handleAsync((r,
					e) ->
			{
				System.out.println("Handle : " + Thread.currentThread().getName());
				if (e == null) {
					return r;
				} else {
					return e.getMessage();
				}
			});
		}
		
		System.out.println("Ben buradayým");
		try {
			Thread.sleep(1000);
		} catch (Exception e2) {
		}
	}
}
