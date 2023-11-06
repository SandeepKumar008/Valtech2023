package com.valtech.training.spring;

public interface Arithmetic {
	
	int ZERO = 0;
	//in interface the variables is always constant
	//so constant shld be weell defined at the time of declaration
	
	int add(int a,int b); //it is public
	
	int sub(int a,int b);
	
	int mul(int a,int b);
	
	int div(int a,int b) throws DivideByZeroException;
	
	//overloading can b done in  interface methods
	
	

}
