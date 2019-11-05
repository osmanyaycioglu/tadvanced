package com.tt.training;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = { "com.tt" })
public class TurkcellspringApplication {

	private IMyInterface myInterface;

	@Autowired
	public TurkcellspringApplication(@Qualifier("test") IMyInterface myInterface) {
		myInterface.execute();
		this.myInterface = myInterface;
	}

	@PostConstruct
	@PreDestroy
	public void name() {
		myInterface.execute();
	}
	
	@Autowired
	public void methodWiring(IMyInterface myInterface) {
		myInterface.execute();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TurkcellspringApplication.class, args);
		TurkcellspringApplication bean = context.getBean(TurkcellspringApplication.class);
		System.out.println(bean.myInterface.execute());
	}

}
