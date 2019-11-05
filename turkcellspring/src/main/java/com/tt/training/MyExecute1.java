package com.tt.training;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("osman")
public class MyExecute1 implements IMyInterface{

	@Override
	public String execute() {
		return "Execute 1";
	}

}
