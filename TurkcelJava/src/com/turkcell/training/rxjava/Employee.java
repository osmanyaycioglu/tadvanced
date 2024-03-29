package com.turkcell.training.rxjava;

public class Employee {
	private String name;
	private String surname;
	private String phone;
	public Employee() {
	}
	
	
	
	public Employee(String name, String surname, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", phone=" + phone + "]";
	}
	
	
}
