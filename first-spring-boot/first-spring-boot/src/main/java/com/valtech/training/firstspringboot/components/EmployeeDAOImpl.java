package com.valtech.training.firstspringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//CRUD OPERATIONS
//CREATE
//READ
//UPDATE
//DELETE
@Component
public class EmployeeDAOImpl implements EmployeeDao {

	public class EmployeeRowMapper implements RowMapper<Employee> {


		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			//"SELECT ID,NAME,AGE,EXPERIANCE,SENIORITY,SALARY FROM EMPLOYEE"
			Employee e = new Employee();
			e.seteid(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperiance(rs.getInt(4));
			e.setSeniority(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			return e;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public long count() {
		String countQry = "select count(eid) from employee";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	// alternative code without springboot

//	@Override
//	public long count() throws SQLException {
//		Connection conn = getConnection();
//		PreparedStatement ps = conn.prepareStatement("select count(id) from employee");
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		long count = rs.getLong(1);
//		conn.close();
//		return count;
//	}

	@Override
	public void deleteEmployee(int eid) {
		String deleteQry = "DELETE FROM EMPLOYEE WHERE EID = ?";
		new JdbcTemplate(dataSource).update(deleteQry, eid);
	}

	// alternative without SpringBoot

//	@Override
//	public void deleteEmployee(int id) throws SQLException {
//		Connection conn = getConnection();
//		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
//		ps.setInt(1, id);
//		int rowsUpdated = ps.executeUpdate();
//		System.out.println("Rows updated = " + rowsUpdated);
//		conn.close();
//	}

	@Override
	public void updateEmployee(Employee emp) {
		String updateQry = "UPDATE EMPLOYEE SET NAME = ?,AGE = ?, EXPERIANCE = ?, SENIORITY = ?,SALARY = ? WHERE EID =";

		new JdbcTemplate(dataSource).update(updateQry, emp.getName(), emp.getAge(), emp.getExperiance(),
				emp.getSeniority(), emp.getSalary(),emp.geteid());
	}

//	without SpringBoot
//	@Override
//	public void updateEmployee(Employee emp) throws SQLException {
//		Connection conn = getConnection();
//		PreparedStatement ps = conn.prepareStatement(
//				"UPDATE EMPLOYEE SET NAME = ?,AGE = ?, EXPERIANCE = ?, SENIORITY = ?,SALARY = ? WHERE ID =?");
//		populatepreparedstatementfromemployee(emp, ps);
//		ps.setInt(6, emp.getId());
//		int rowsUpdated = ps.executeUpdate();
//		System.out.println("Rows updated = " + rowsUpdated);
//		conn.close();
//	}

	@Override
	public void saveEmployee(Employee emp) {

	}

	@Override
	public void createEmployee(Employee emp) {
		String createQry = "INSERT INTO EMPLOYEE(NAME,AGE,EXPERIANCE,SENIORITY,SALARY) VALUES (?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, emp.getName(), emp.getAge(), emp.getExperiance(),
				emp.getSeniority(), emp.getSalary(),emp.geteid());
	}

//	without springBoot

//	@Override
//	public void createEmployee(Employee emp) throws SQLException {
//		Connection conn = getConnection();
//		PreparedStatement ps = conn
//				.prepareStatement("INSERT INTO EMPLOYEE(NAME,AGE,EXPERIANCE,SENIORITY,SALARY) VALUES (?,?,?,?,?)");
//		populatepreparedstatementfromemployee(emp, ps);
//		int rowsUpdated = ps.executeUpdate();
//		System.out.println("Rows updated = " + rowsUpdated);
//		conn.close();
//	}
	@Override
	public List<Employee> getAllEmployee() {
		
		String selectAllQry="SELECT EID,NAME,AGE,EXPERIANCE,SENIORITY,SALARY FROM EMPLOYEE";
		
		return new JdbcTemplate(dataSource).query(selectAllQry, new EmployeeRowMapper());
		
	}
//without SpringBoot

//	@Override
//	public List<Employee> getAllEmployee() throws SQLException {
//		Connection conn = getConnection();
//		PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,EXPERIANCE,SENIORITY,SALARY FROM EMPLOYEE");
//		ResultSet rs = ps.executeQuery();
//		List<Employee> emps = new ArrayList<>();
//		while (rs.next()) {
//			emps.add(mapRowToEmployee(rs)); // right click--> refactor --> extract method
//		}
//		conn.close();
//		return emps;
//	}

	@Override
	public Employee getEmployee(int id) {
		String selectAllQry="SELECT EID,NAME,AGE,EXPERIANCE,SENIORITY,SALARY FROM EMPLOYEE WHERE ID = "+id;
		return (Employee) new JdbcTemplate(dataSource).query(selectAllQry, new EmployeeRowMapper());
				
				
				
				
				


}
}