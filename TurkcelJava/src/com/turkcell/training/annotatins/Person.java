package com.turkcell.training.annotatins;

@PropertySource("my.properties")
public class Person {
	@Property("person.name")
	private String name;
	@Property("person.surname")
	private String surname;
	
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
	
}
