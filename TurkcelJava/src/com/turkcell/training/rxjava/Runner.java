package com.turkcell.training.rxjava;

public class Runner {
	public static void main(String[] args) {
		Employee employee = new Employee("osman", "yay", "5442323");
		PrintService printService = new PrintService();
		printService.print(employee);
		
		Customer customer = new Customer();
		customer.setIsim("ali");
		customer.setSoyisim("vali");
		
		printService.print(new CustomerEmployeeAfaptor(customer));
		
	}
}
