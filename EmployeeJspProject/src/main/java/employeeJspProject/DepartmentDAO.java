package employeeJspProject;

import java.sql.*;

import java.util.List;

public interface DepartmentDAO {

	void deleteDepartment(int did) throws SQLException;

	void updateDepartment(Department dep) throws SQLException;

	void createDepartment(Department dep) throws SQLException;

	List<Department> getAllDepartment() throws SQLException;
	
	List<GroupBy> getListofEmployeeinEachDepartment() throws SQLException;

	Department getDepartment(int did) throws SQLException;
	
	DepartmentJoin getEmployeeByDepartment(int did) throws SQLException;
	
	List<DepartmentJoin> getEmployeeByLocation(String dlocation) throws SQLException ;
	
}