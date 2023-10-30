package com.valtech.training.day4;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

	public long count() throws SQLException;
	
	void deleteDepartment(int deptID) throws SQLException;
	
	void updateDepartment(Department dept) throws SQLException;
	
	void addDepartment(Department dept) throws SQLException;
	
	Department getDepartment(int deptID) throws SQLException;
	
	List<Department> getAllDepartments() throws SQLException;
	
	List<Employee> getAllEmployeesByDepartment(int deptID) throws SQLException;
	
}
