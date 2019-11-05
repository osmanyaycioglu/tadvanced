package com.turkcell.training.annotatins;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyEngineTest {
	
	public PropertyEngineTest() {
		System.out.println("PropertyEngineTest()");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll()");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll()");
	}
	
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach()");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("afterEach()");
	}

	@Test
	void testProcessClass() throws Exception {
		PropertyEngine<ServerConnection> serEngine = new PropertyEngine<>();
		ServerConnection processClass = serEngine.processClass(ServerConnection.class);
		Assertions.assertEquals(8080, processClass.getPort());
		Assertions.assertEquals("192.168.1.1", processClass.getIp());
		
	}

	@Test
	void testProcessClass2() throws Exception {
		PropertyEngine<ServerConnection> serEngine = new PropertyEngine<>();
		ServerConnection processClass = serEngine.processClass(ServerConnection.class);
		Assertions.assertEquals(8080, processClass.getPort());
		Assertions.assertEquals("192.168.1.1", processClass.getIp());
		
	}

}
