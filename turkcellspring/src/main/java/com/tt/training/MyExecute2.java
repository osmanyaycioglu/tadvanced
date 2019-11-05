package com.tt.training;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class MyExecute2 implements IMyInterface{

	@Override
	public String execute() {
		return "Execute 2";
	}

}
