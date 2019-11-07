package com.turkcell.training.mt.thp;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Hello world";
	}

}
