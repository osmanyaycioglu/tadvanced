package com.tt.training.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner{

	@Autowired
	private CustomerDAO custDAO;
	
	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setAge(49);
		customer.setName("osman");
		customer.setSurname("yay");
		custDAO.save(customer);
		
	}

}
