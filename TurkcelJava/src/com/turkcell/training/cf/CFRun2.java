package com.turkcell.training.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.turkcell.training.mt.MyRunnable;

public class CFRun2 {
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		// CompletableFuture<String> cf = new CompletableFuture<>();
		CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "hello world";
		}, newCachedThreadPool).thenAccept(r -> System.out.println(r));

		CompletableFuture<Void> allOf = CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "hello world";
		}, newCachedThreadPool), CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "hello world";
		}, newCachedThreadPool), CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "hello world";
		}, newCachedThreadPool));

		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> "hello world");

		// String join = supplyAsync.join();
		boolean complete = supplyAsync.complete("sonuc yok");
		supplyAsync.getNow("sonuc gelmedi");

		try {
			supplyAsync.get(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String join = supplyAsync.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		CompletableFuture.supplyAsync(() -> {
			System.out.println("Async : " + Thread.currentThread().getName());

			return "hello world";
		}).handle((r,
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
}
