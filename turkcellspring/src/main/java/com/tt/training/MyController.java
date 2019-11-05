package com.tt.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
public class MyController {
	
	@Qualifier("test")
	private IMyInterface myInterface;;
	
	public MyController() {
		System.out.println("MyController()");
	}
	
	@GetMapping
	public String hello() {
		return "hello world 2";
	}
}
