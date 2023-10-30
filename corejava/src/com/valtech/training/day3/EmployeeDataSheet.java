package com.valtech.training.day3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.valtech.training.day1.Point;


public class EmployeeDataSheet implements Comparable<EmployeeDataSheet>{
	Integer Salary;
	Integer age;
	Integer experiance;
	String name;
	
	public EmployeeDataSheet(String n,int ag, int exp, int sal) {
		name = n;
		age = ag;
		experiance = exp;
		Salary = sal;
	}

	public EmployeeDataSheet() {}

	public String toString() {
		
		return "\n name = "+ name +" age = "+age+ " experiance = "+experiance+" salary = "+Salary;
	}
	
	@Override
	public int compareTo(EmployeeDataSheet o) {
		// TODO Auto-generated method stub
		return this.experiance.compareTo(o.experiance) + (this.Salary.compareTo(o.Salary));//+ (this.name.compareTo(o.name))+(this.age.compareTo(o.age));
	}

	
}

