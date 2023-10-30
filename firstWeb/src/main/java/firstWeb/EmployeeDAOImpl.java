package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD OPERATIONS
//CREATE
//READ
//UPDATE
//DELETE

public class EmployeeDAOImpl implements EmployeeDao {
	

	
	@Override
	public long count() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("select count(id) from employee");
		ResultSet rs = ps.executeQuery();		
		rs.next();
		long count = rs.getLong(1);
		conn.close();		
		return count; 
	}
	
	
	@Override
	public void deleteEmployee(int id) throws SQLException{
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("DELETE FROM EMPLOYEE WHERE ID = ?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated = "+rowsUpdated);
		conn.close();
		
	}
	
	
	
	@Override
	public void updateEmployee(Employee emp) throws SQLException{
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("UPDATE EMPLOYEE SET NAME = ?,AGE = ?, EXPERIANCE = ?, SENIORITY = ?,SALARY = ? WHERE ID =?");
		populatepreparedstatementfromemployee(emp, ps);
		ps.setInt(6, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated = "+rowsUpdated);
		conn.close();
	}
	
	
	@Override
	public void saveEmployee(Employee emp) {
		
		
	}
	
	@Override
	public void createEmployee(Employee emp) throws SQLException {
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("INSERT INTO EMPLOYEE(NAME,AGE,EXPERIANCE,SENIORITY,SALARY) VALUES (?,?,?,?,?)");
		populatepreparedstatementfromemployee(emp, ps);
		
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows updated = "+rowsUpdated);
		conn.close();
	}



	private void populatepreparedstatementfromemployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3,emp.getExperiance());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
	}
	
	
	@Override
	public List<Employee> getAllEmployee() throws SQLException {
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("SELECT ID,NAME,AGE,EXPERIANCE,SENIORITY,SALARY FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));       //right click--> refactor --> extract method
		}
		conn.close();
		return emps;
		
	}
	
	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("SELECT ID,NAME,AGE,EXPERIANCE,SENIORITY,SALARY FROM EMPLOYEE WHERE ID = ?");
	//prepared statement for the execution plan
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
//this is how to achive refactoring
			Employee e = mapRowToEmployee(rs);
			conn.close();
			return e;
		}
		else {
			System.out.println("No row with id = " +id+" found......");
			return null; //ideally no null shld be there
		}
		
	}



	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperiance(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		return e;
	}
	
	private Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL= false","root","root");
		//SSL sequre software layer
	}


	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");//this loads the deliver later register to driver manager
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();		}
	}




	public static void main(String[] args) throws Exception{
		EmployeeDao dao = new EmployeeDAOImpl();
//		System.out.println(dao.getEmployee(5));
//		System.out.println(dao.getEmployee(2));
	//	System.out.println(dao.getAllEmployee());
		
//		dao.createEmployee(new Employee("Xxy",33,8,4,70000));
//		Employee e = dao.getEmployee(2);
//		e.setSeniority(5);
//		dao.updateEmployee(e);
//		dao.deleteEmployee(3);
//		System.out.println(dao.count());
//		System.out.println(dao.getAllEmployee());
		dao.count();
		System.out.println(dao.getAllEmployee());
		
	}


	@Override
	public int firstId() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("SELECT min(id) from employee");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
			return id;
		}
		
		return 0;
	}


	@Override
	public int LastId() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("SELECT max(id) from employee");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			conn.close();
		
		}
		return 0;
	}


	@Override
	public int nextId(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("select min(id) from employee where id>?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			 id = rs.getInt(1);
			conn.close();
		
		}
		
		return id ==0 ? LastId() : id;	}


	@Override
	public int previousId(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement
				("select max(id) from employee where id<?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			 id = rs.getInt(1);
			conn.close();
		
		}
		return id == 0 ? firstId() : id;
	}


//	@Override
//	public List<Employee> getAllEmployeeByDepartment(int department_id) throws SQLException {
//			List<Employee> employee = new ArrayList<>();
//			Connection conn = getConnection();
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE Department_id = ?");
//			ps.setInt(7, department_id);
//			ResultSet rs = ps.executeQuery();
//			return employee;
//		}
//	





	

}
