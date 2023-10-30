package com.valtech.training.new12;

public class AdderImpl implements Adder{
	
	
	@Override
	public int add(int variable1, int variable2) {
		return variable1 + variable2;
		
	}
	public static void main(String[] args) {
		Adder a = new AdderImpl();
		System.out.println(a.add(2,3));
		
		//anonymous class
		Adder a1 = new Adder() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
			
		};
		
		//Lambda expression
		Adder a2 = (i,j) -> {return i+j;};
		System.out.println(a2.add(3, 4));
		
	}

	

}

