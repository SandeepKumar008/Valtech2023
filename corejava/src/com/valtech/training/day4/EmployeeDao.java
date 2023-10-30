package com.valtech.training.day4;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao  {
	
	public long count() throws SQLException;

	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void saveEmployee(Employee emp);

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployee() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	
//	List<Employee> getAllEmployeeByDepartment(int department_id) throws SQLException;
	
	

}