package com.tt.training;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = 
	@QueueBinding(value = 
		@Queue(value = "tc-completed",autoDelete = "false",arguments = 
				@Argument(name = "x-message-ttl", value = "10000", type = "java.lang.Integer"),
				durable="true"), 
				exchange = @Exchange(value = "ex-return", 
						type = ExchangeTypes.DIRECT, autoDelete = "false",durable="true"), 
				key="completed.cdr")
)
public class MyRabbitListener5 {
	
	@RabbitHandler
	public void handleMe(String msg) {
		System.out.println("Completed cdr : " + msg);
	}

}
