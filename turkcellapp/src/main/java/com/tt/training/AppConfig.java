package com.tt.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AppConfig {
	
	@Autowired
	private FileReader fr;
	
	@Scheduled(fixedDelay = 2000)
	public void read() {
		fr.readFile("cdr1.txt");
	}
}
