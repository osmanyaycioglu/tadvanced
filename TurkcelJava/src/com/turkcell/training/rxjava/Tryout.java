package com.turkcell.training.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class Tryout {
	public static void main(String[] args) {
		Observable.create(sub -> {
			for (int i = 0; i < 1_000_000; i++) {
				System.out.println("[PRODUCER] : " + i + " TH : " + Thread.currentThread().getName());
				Thread.sleep(10);
				sub.onNext("" + i);
			}
			sub.onComplete();
		} )
		.subscribeOn(Schedulers.computation())
		.observeOn(Schedulers.computation())
		.doAfterNext(f->{
			System.out.println("[DONEXT1] : " + f + " TH : " + Thread.currentThread().getName());
			
		} )
		.map(s -> {
			System.out.println("[MAP] : " + s + " TH : " + Thread.currentThread().getName());
			return s + "a";
		}).observeOn(Schedulers.computation())
		.doAfterNext(f -> {
			System.out.println("[DONEXT2] : " + f + " TH : " + Thread.currentThread().getName());

		})
		.toFlowable(BackpressureStrategy.BUFFER)
		.subscribe(s -> {
			Thread.sleep(10);
			System.out.println("[SUBSCRIBER] : " + s + " TH : " + Thread.currentThread().getName());
		});
		
		try {
			Thread.sleep(10_000);
		} catch (Exception e) {
		}
	}
}
