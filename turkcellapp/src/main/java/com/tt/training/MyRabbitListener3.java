package com.tt.training;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "tc-queue-2")
public class MyRabbitListener3 {
	
	@RabbitHandler
	public void handleMe(String msg) {
		System.out.println("Received 3 : " + msg);
	}

}
