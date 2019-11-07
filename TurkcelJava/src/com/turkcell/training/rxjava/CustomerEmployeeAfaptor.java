package com.turkcell.training.rxjava;

public class CustomerEmployeeAfaptor extends Employee{
	private Customer customer;

	public CustomerEmployeeAfaptor(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String getName() {
		
		return customer.getIsim();
	}
	@Override
	public String getSurname() {
		
		return customer.getSoyisim();
	}

}
