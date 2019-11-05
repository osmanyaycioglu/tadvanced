package com.turkcell.training.patterns;

public class BuilderName {

	public static void main(String[] args) {
		Connection nConnection = Connection.getBuilder()
					.withUrl("http://")
					.withUsername("osso")
					.withPassword("1233")
					.build();
	}
}
