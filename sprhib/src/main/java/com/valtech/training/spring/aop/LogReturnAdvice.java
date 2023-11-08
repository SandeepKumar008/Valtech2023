package com.valtech.training.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

public class LogReturnAdvice implements AfterReturningAdvice{
//cliked on afterreurningadvice later attachsource .from tools, add the aop source from spring 
	@Override
	public void afterReturning(Object returnType, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("Return Value"+returnType);
	}
	

}
