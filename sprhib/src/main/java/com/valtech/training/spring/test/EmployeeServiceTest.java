package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.EmployeeService;

class EmployeeServiceTest {

	private ApplicationContext appCtx;
	private DateFormat dateFormat;

	@BeforeEach
	void setUp() throws Exception {

		appCtx = new ClassPathXmlApplicationContext("tx2.xml");
		dateFormat = new SimpleDateFormat("dd-mm-yy");

	}

	@AfterEach
	void tearDown() throws Exception {
		((ClassPathXmlApplicationContext) appCtx).close();
	}

	@Test
	void test() throws Exception {
		Employee e = new Employee("ABS", dateFormat.parse("15-09-1947"), 10000, 'm', false);
		EmployeeService empSer= (EmployeeService)appCtx.getBean("empSer");
		e = empSer.createEmployee(e);
		System.out.println(e);
		e=empSer.IncrementSalary(e, 1000);
		System.out.println(e);
		
		
	}

}
