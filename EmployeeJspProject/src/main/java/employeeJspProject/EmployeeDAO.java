package employeeJspProject;

import java.sql.*;

import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int eid) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int eid) throws SQLException;
	
	List<Employee> getEmployeeSeniority(int seniority) throws SQLException ;
	
	List<Employee> getEmployeeSalaryGreater(int salary) throws SQLException;
	
	List<Employee> getEmployeeSalaryLesser(int salary) throws SQLException;
	
	List<Employee> getEmployeeAgeBetween(int min, int max) throws SQLException;
	
	long count() throws SQLException;

}