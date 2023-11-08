package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;
import com.valtech.training.spring.DivideByZeroException;

class AOPTest {
	
	private ClassPathXmlApplicationContext appCtx;  //this is copied from ioctest
	
    @BeforeEach
    void initialize() {
    	appCtx=new ClassPathXmlApplicationContext("aop.xml");
    }
    
    @AfterEach
    void closeall() {
    	appCtx.close();
    }

	@Test
	void test() {
		Arithmetic arith = (Arithmetic) appCtx.getBean(Arithmetic.class);
		System.out.println(arith.getClass().getName());
//		System.out.println(arith); //this was commented
		assertEquals(5, arith.add(2, 3));
		assertEquals(-1, arith.sub(2, 3));
		assertEquals(5, arith.add(3, 2));
		try {
			arith.div(5, 0);
			fail("no exception occured");
		} catch (Exception e) {
		}
	}

}
