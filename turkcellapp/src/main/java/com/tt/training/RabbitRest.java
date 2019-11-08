package com.tt.training;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitRest {
	
	@Autowired
	private RabbitTemplate rt;
	
	@GetMapping("/send/{message}")
	public String sendMessage(@PathVariable("message") String msg) {
		rt.convertAndSend("tc-direct","com.tc.cdr",msg);
		return "ok";
	}
}
