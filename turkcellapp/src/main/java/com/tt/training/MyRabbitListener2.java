package com.tt.training;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "tc-queue-1")
public class MyRabbitListener2 {
	
	@RabbitHandler
	public void handleMe(String msg) {
		System.out.println("Received 2 : " + msg);
	}

}
