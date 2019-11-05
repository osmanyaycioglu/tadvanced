package com.tt.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tt.MyExecute3;

@Configuration
public class ExecuteConfiguration {
	
	@Autowired
	private TomcatWebServerFactoryCustomizer ec;
	
	@Bean
	public IMyInterface createExecute1() {
		return new MyExecute1();
	}
	
	
	
	@Bean
	@Qualifier("test")
	public IMyInterface createExecute2() {
		return new MyExecute2();
	}
	
	@Bean
	public IMyInterface createExecute3() {
		return new MyExecute3();
	}

	@Bean
	public IMyInterface createExecute3(@Value("${execute.index}") int index) {
		switch (index) {
		case 1:
			return new MyExecute1();
		case 2:
			return new MyExecute2();
		case 3:
			return new MyExecute3();
		default:
			return new MyExecute1();
		}
	}
	
	@Bean
	@Qualifier("mybean")
	public MyBean createMyBean() {
		return new MyBean();
	}

	@Bean
	public IMyInterface createExecute4(@Value("#{mybean.getIndex()}") int index) {
		switch (index) {
		case 1:
			return new MyExecute1();
		case 2:
			return new MyExecute2();
		case 3:
			return new MyExecute3();
		default:
			return new MyExecute1();
		}
	}
	
	@Bean
	public IMyInterface createExecute4(MyBean bean) {
		switch (bean.getIndex()) {
		case 1:
			return new MyExecute1();
		case 2:
			return new MyExecute2();
		case 3:
			return new MyExecute3();
		default:
			return new MyExecute1();
		}
	}

	@Bean
	public IMyInterface createExecute5() {
		MyBean bean = createMyBean();
		MyBean bean1 = createMyBean();
		MyBean bean2 = createMyBean();
		MyBean bean3 = createMyBean();
		
		switch (bean.getIndex()) {
		case 1:
			return new MyExecute1();
		case 2:
			return new MyExecute2();
		case 3:
			return new MyExecute3();
		default:
			return new MyExecute1();
		}
	}


}
