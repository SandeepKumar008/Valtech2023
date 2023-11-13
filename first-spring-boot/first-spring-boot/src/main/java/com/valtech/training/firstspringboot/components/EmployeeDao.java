package com.valtech.training.firstspringboot.components;

import java.util.List;

public interface EmployeeDao  {
	
	public long count()  ;

	void deleteEmployee(int eid)  ;

	void updateEmployee(Employee emp) ;

	void saveEmployee(Employee emp);

	void createEmployee(Employee emp) ;

	List<Employee> getAllEmployee()  ;

	Employee getEmployee(int eid)  ;
	
//	List<Employee> getAllEmployeeByDepartment(int department_id) throws SQLException;
	
	

}