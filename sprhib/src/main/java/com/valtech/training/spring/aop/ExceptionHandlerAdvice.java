package com.valtech.training.spring.aop;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionHandlerAdvice implements ThrowsAdvice{
	
	public void afterThrowing(Exception ex) {
		System.out.println("Exception Message"+ex.getMessage());
	}

}
