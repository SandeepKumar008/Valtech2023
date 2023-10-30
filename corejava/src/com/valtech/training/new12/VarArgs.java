package com.valtech.training.new12;

import java.util.Iterator;

public class VarArgs {
	
	public int add(int a,int ... b) {
		//b is an array ..length property on integer array....at compile time bundle and send the b
		//Varargs shld be last arguments
		int result = a;
		for (int b1 : b) {
			result+=  b1;
			
		}
		return result;
	}
	

	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		System.out.println(va.add(2)); //a = 2, b = emplty array not nuill
		//here 1 argument is mandatory bcz int a meaning is that..atleast one...later comes b...meaning next any num is b
		//shld pass 1 or more
		System.out.println(va.add(2, 3));
		System.out.println(va.add(2, 3,4));
		
		//va.add(2, 3); //a= 2 b= 3
	//	va.add(2, 3,4); //
	//	(int c ,int a,int ...b)  so here c and a is mandatory..VarArgs.b is 
	//	va.add(2, 3,4,5);
		
	}

}
