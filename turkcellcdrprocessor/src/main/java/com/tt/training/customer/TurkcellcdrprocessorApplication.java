package com.tt.training.customer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class TurkcellcdrprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurkcellcdrprocessorApplication.class, args);
	}

}
