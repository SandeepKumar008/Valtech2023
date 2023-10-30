package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSorting {
	
	public static void main(String[] args) {
		EmployeeDataSheet emp1 = new EmployeeDataSheet("aaaa", 28, 5, 7000000);
		EmployeeDataSheet emp2 = new EmployeeDataSheet("bbbb", 50, 10, 1700000);
		EmployeeDataSheet emp3 = new EmployeeDataSheet("cccc", 33, 14, 2700000);
		EmployeeDataSheet emp4 = new EmployeeDataSheet("dddd", 37, 17, 1800000);

		List<EmployeeDataSheet> l1 = new ArrayList<EmployeeDataSheet>();
		l1.add(emp1);
		l1.add(emp2);
		l1.add(emp3);
		l1.add(emp4);
		
		Collections.sort(l1);
		
		
		System.out.println(l1);
	}

}
