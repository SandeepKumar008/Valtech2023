package com.valtech.training.spring;

import java.util.Set;

public class SimpleInterestImpl implements SimpleInterest {
	
	public SimpleInterestImpl() {
	}

	private Arithmetic arithmetic;
	
	public  SimpleInterestImpl(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
 
	}
	
	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Override
	public double computeinterest(int prin, int rate, int duration) throws DivideByZeroException {
		
		int result = arithmetic.mul(prin, rate);
//		result = arithmetic.mul(result, duration);
//		return arithmetic.div(result, 0);
//		//ptr/100
		try {
			return arithmetic.div(result, 1);
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) throws DivideByZeroException {
		Arithmetic arithmetic = new ArithmeticImpl();
		SimpleInterest si = new SimpleInterestImpl(arithmetic);
		System.out.println(si.computeinterest(200, 3, 4));
		
	}
}
