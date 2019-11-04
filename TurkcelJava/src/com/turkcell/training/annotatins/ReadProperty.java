package com.turkcell.training.annotatins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("my.properties"));
		
		ServerConnection connection =  new ServerConnection();
		connection.setIp(properties.getProperty("server.ip"));
		connection.setPort(Integer.parseInt(properties.getProperty("server.port")));
		connection.setDesc(properties.getProperty("server.desc"));
		
		System.out.println(connection);
		
		
	}
}
