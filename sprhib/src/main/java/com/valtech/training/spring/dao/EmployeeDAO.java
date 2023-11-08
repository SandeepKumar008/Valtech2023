package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;

public interface EmployeeDAO {

	Employee saveEmployee(Employee emp);

	Employee loadEmployee(int empId);

	Employee updatEmployee(Employee emp);

	void deleteEmployee(Employee emp);

	List<Employee> getAllEmployee();

}