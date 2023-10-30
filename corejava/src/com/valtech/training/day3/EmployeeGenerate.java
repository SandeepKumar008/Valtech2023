package com.valtech.training.day3;

import java.util.Random;

public class EmployeeGenerate {
	
	int age;
	String Name;
	int level;
	int experiance;
	
	String GenerateRandomName() {
		//create a string of uppercase and lowercase 
		String uppercase = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String lowercase = "qwertyuiopasdfghjklzxcvbnm";
		
		
//		//combine all string
//		String lower_and_upper = uppercase + lowercase;
		
		//create random string builder
	    //StringBuilder objects aare like String objects except that they can be modified.these obj are treated like variable -len arrays 
	    //that contain a sequence of chars.here the len and content of the sequence can be changed through method invocations .
		StringBuilder sb = new StringBuilder();
		
		//create an object of random class
		Random random = new Random();
		
		//Specify the len of random String
		int lenofstring = 15;
		char randomcharup = uppercase.charAt(random.nextInt(uppercase.length()));
		sb.append(randomcharup);
		
		for(int i = 1; i < lenofstring; i++) {
			 //generate random index number
			int index = random.nextInt(lowercase.length());
			
			//get the char specified by the index from the string
			char randomchar = lowercase.charAt(index);
			
			sb.append(randomchar);
			
		}
		return sb.toString();
		
	}
	
	 EmployeeGenerate Generate(EmployeeGenerate x) 
	{
		
		
		Random rand = new Random();
		//for age
		int upperbound = 60;
		int lowerbound = 20;
		
		//for the experiance
		int max_exp= 50;
		int min_exp = 1;
		
		//for the level
		int low_level = 1;
		int high_level = 5;
		
		
		x.age = rand.nextInt((upperbound - lowerbound)+1) +lowerbound;
//		x.experiance = rand.nextInt((x.age-20;));
		
		x.experiance = rand.nextInt((x.age - 20)+1) + 0;		
		x.level = rand.nextInt(high_level-low_level + 1) + low_level;
		
		
		x.Name=GenerateRandomName();
		
//		if(x.age == rand.nextInt((upperbound - lowerbound)+1) +lowerbound))
//		{
//			x.experiance = x.age-20;
//		//	x.level = rand.nextInt(high_level-low_level + 1) + low_level;;
//		}
//		
//		
//		//x.experiance = rand.nextInt((max_exp - min_exp)+ 1)+ min_exp;
		
		return x;
	}
	
	public static void main(String[] args) {
		EmployeeGenerate e1 = new EmployeeGenerate();
		EmployeeGenerate e2 = new EmployeeGenerate();
		EmployeeGenerate e3 = new EmployeeGenerate();
		EmployeeGenerate e4 = new EmployeeGenerate();
		EmployeeGenerate e5 = new EmployeeGenerate();
		EmployeeGenerate e6 = new EmployeeGenerate();
		
		e1.Generate(e1);
		e2.Generate(e2);
		e3.Generate(e3);
		e4.Generate(e4);
		e5.Generate(e5);
		e6.Generate(e6);
		
		System.out.println("Name = "+e1.Name +" Age = "+ e1.age+" Experiance = " + e1.experiance+" Level = "+ e1.level);
		System.out.println("Name = "+e2.Name +" Age = "+ e2.age+" Experiance = " + e2.experiance+" Level = "+ e2.level);
		System.out.println("Name = "+e3.Name +" Age = "+ e3.age+" Experiance = " + e3.experiance+" Level = "+ e3.level);
		System.out.println("Name = "+e4.Name +" Age = "+ e4.age+" Experiance = " + e4.experiance+" Level = "+ e4.level);
		System.out.println("Name = "+e5.Name +" Age = "+ e5.age+" Experiance = " + e5.experiance+" Level = "+ e5.level);

		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}