package com.turkcell.training.annotatins;

public class MainRunner {
	static {
		System.out.println("Static block");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("main");
		PropertyEngine<ServerConnection> serEngine = new PropertyEngine<>();
		ServerConnection processClass = serEngine.processClass(ServerConnection.class);
		System.out.println(processClass);
	
		PropertyEngine<Person> engine = new PropertyEngine<>();
		Person processClass2 = engine.processClass(Person.class);
	
	}
}
