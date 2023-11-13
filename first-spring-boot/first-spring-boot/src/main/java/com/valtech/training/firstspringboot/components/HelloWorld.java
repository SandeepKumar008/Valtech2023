package com.valtech.training.firstspringboot.components;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

	public  String hello() {
		return "Hello Spring Boot";
	}
}
