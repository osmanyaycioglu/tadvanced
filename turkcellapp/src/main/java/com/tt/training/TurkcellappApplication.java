package com.tt.training;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class TurkcellappApplication {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("127.0.0.1");
        cachingConnectionFactory.setUsername("osman");
        cachingConnectionFactory.setPassword("osman12");
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }
    
    @Bean
    public RabbitTemplate RabbitTemplate(ConnectionFactory connectionFactory) {
    	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    	// rabbitTemplate.setMessageConverter(new TextMe);
    	return rabbitTemplate;
    }

	@Bean
	public Queue myQueue1() {
		return QueueBuilder.durable("tc-queue-1").build();
	}

	@Bean
	public Queue myQueue2() {
		return QueueBuilder.durable("tc-queue-2").build();
	}

	@Bean
	public DirectExchange myDirectExchange() {
		return ExchangeBuilder.directExchange("tc-direct").durable(true).build();
	}

	@Bean
	public Binding myBinding1(@Qualifier("myDirectExchange") DirectExchange exchange) {
		return BindingBuilder.bind(myQueue1()).to(exchange).with("com.tc.cdr");
	}

	@Bean
	public Binding myBinding2(@Qualifier("myDirectExchange") DirectExchange exchange) {
		return BindingBuilder.bind(myQueue2()).to(exchange).with("com.tc.tdr");
	}

	public static void main(String[] args) {
		SpringApplication.run(TurkcellappApplication.class, args);
	}

}
