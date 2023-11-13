package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.DivideByZeroException;
import com.valtech.training.firstspringboot.components.EmployeeDao;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.service.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SimpleInterest simpleInterest;
	
	
	
	
	
	void testSI() throws DivideByZeroException {
		simpleInterest.computeinterest(200000, 3, 3);
	}
	
	@Test
	void testEmployeeDao() {
		assertEquals(2, employeeDao.count());
		assertEquals(2, employeeDao.getAllEmployee().size());
	}
	@Test
	void testOrders() {
		Order o= orderService.createOrder(new Order("Macbook pro",25,"for the Entire Team",LocalDate.of(2023, 11, 8)));
		assertNotEquals(0,o.getId());
		assertTrue(orderService.getAllOrders().size()>0);
		
		
	}
	
	@Test
	void contextLoads() {
		
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

}
