package com.tt.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class MyBean {
	
	@Autowired
	private Environment environment;
	
	public int getIndex() {
		return Integer.parseInt(environment.getProperty("execute.index"));
	}
}
