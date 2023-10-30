package employeeJspProject;

import java.sql.*;
import java.util.*;

public class EmployeeTable implements EmployeeDAO {
	
	static Scanner scn = new Scanner(System.in);
	
	public long count() throws SQLException{
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(EID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			return rs.getLong(1);
		}
		con.close();
		return rs.getLong(1);
		
	}

	@Override
	public void deleteEmployee(int eid) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE EID=?");
		ps.setInt(1, eid);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated:" + rowsUpdated);
		con.close();

	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE EMPLOYEE SET NAME = ?, AGE = ?, EXPERIENCE = ?, SENIORITY = ?, SALARY = ?, DID = ? WHERE EID = ?");
		populatePreparedStatmentFromEmployee(emp, ps);
		ps.setInt(7, emp.getEid());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.
				prepareStatement("INSERT INTO EMPLOYEE (NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID, EID) VALUES (?, ?, ?, ?, ?, ?, ?)");
		populatePreparedStatmentFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	private void populatePreparedStatmentFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
		ps.setInt(6, emp.getDid());
		ps.setInt(7, emp.getEid());
	
	}

	public List<Employee> getAllEmployees() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {

			emps.add(mapRowToEmployee(rs));
		
		}

		con.close();
		return emps;

	}

	public Employee getEmployee(int eid) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT EID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DID FROM EMPLOYEE WHERE EID=?");
		ps.setInt(1, eid);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;

		} 
		else {

			System.out.println("No row with Id " + eid + " found.");
			return null;

		}

	}
	
	public List<Employee> getEmployeeAgeBetween(int min, int max) throws SQLException {

		Connection con=getConnection();
		PreparedStatement ps=con
				.prepareStatement("SELECT * FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps=new ArrayList<>();

		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		con.close();
		return emps;
	}
	
	public List<Employee> getEmployeeSeniority(int seniority) throws SQLException {

		Connection con=getConnection();
		PreparedStatement ps=con
				.prepareStatement("SELECT EID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DID FROM EMPLOYEE WHERE SENIORITY=?");
		ps.setInt(1, seniority);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps=new ArrayList<>();

		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		con.close();
		return emps;
	}
	
	public List<Employee> getEmployeeSalaryGreater(int salary) throws SQLException {

		Connection con=getConnection();
		PreparedStatement ps=con
				.prepareStatement("SELECT EID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID FROM EMPLOYEE WHERE SALARY>?");
		ps.setInt(1, salary);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps=new ArrayList<>();

		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		con.close();
		return emps;
	}
	
	public List<Employee> getEmployeeSalaryLesser(int salary) throws SQLException {

		Connection con=getConnection();
		PreparedStatement ps=con
				.prepareStatement("SELECT EID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID FROM EMPLOYEE WHERE SALARY<?");
		ps.setInt(1, salary);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps=new ArrayList<>();

		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		con.close();
		return emps;
	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {

		Employee e = new Employee();
		e.setEid(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		e.setDid(rs.getInt(7));
		return e;

	}

	static {

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL = false", "root", "root");

	}

	public static void main(String[] args) throws SQLException {

		EmployeeDAO dao = new EmployeeTable();
		int ch;
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Update");
			System.out.println("4. Delete");
			System.out.println("5. Count");
			System.out.println("6. Search");
			System.out.println("7. Salary Greater than Salary");
			System.out.println("8. Salary Lesser than Salary");
			System.out.println("9. Get Employee Seniority");
			System.out.println("10. Get Employee Age Between");
			System.out.println("Enter your choice:");
			ch = scn.nextInt();
			System.out.println("------------------------------------------------------------------------------");
			switch (ch) {
			case 1:
				System.out.println("Enter the Employee details");
				System.out.println("Employee ID : ");
				int eid = scn.nextInt();
				System.out.println("Names : ");
				scn.nextLine();
				String na = scn.nextLine();
				System.out.println("Age : ");
				int age = scn.nextInt();
				System.out.println("Experience : ");
				int exp = scn.nextInt();
				System.out.println("Seniority : ");
				int sen = scn.nextInt();
				System.out.println("Salary : ");
				int sal = scn.nextInt();
				System.out.println("Department ID : ");
				int did = scn.nextInt();
				dao.createEmployee(new Employee(eid,na,age,exp,sen,sal,did));
				System.out.println(dao.getEmployee(eid));
				break;
			case 2:
				System.out.println(dao.getAllEmployees());
				break;
			case 3:
				System.out.println("Enter the Employee details");
				System.out.println("Employee ID : ");
				int ueid = scn.nextInt();
				System.out.println("Names : ");
				scn.nextLine();
				String una = scn.nextLine();
				System.out.println("Age : ");
				int uage = scn.nextInt();
				System.out.println("Experience : ");
				int uexp = scn.nextInt();
				System.out.println("Seniority : ");
				int usen = scn.nextInt();
				System.out.println("Salary : ");
				int usal = scn.nextInt();
				System.out.println("Department ID : ");
				int udid = scn.nextInt();
				dao.updateEmployee(new Employee(ueid,una,uage,uexp,usen,usal,udid));
				System.out.println(dao.getEmployee(ueid));
				break;
			case 4:
				System.out.println("Enter the employee ID to delete");
				int de = scn.nextInt();
				dao.deleteEmployee(de);
				System.out.println("Employee ID = "+de+" is been deleted");
				break;
			case 5:
				System.out.println("Number of employee : "+dao.count());
				break;
			case 6:
				System.out.println("Enter the employee ID to search");
				int no = scn.nextInt();
				System.out.println(dao.getEmployee(no));
				break;
			case 7:
				System.out.println("Enter the employee salary to compare greater");
				int ge = scn.nextInt();
				System.out.println(dao.getEmployeeSalaryGreater(ge));
				break;
			case 8:
				System.out.println("Enter the employee salary to compare lesser");
				int le = scn.nextInt();
				System.out.println(dao.getEmployeeSalaryLesser(le));
				break;
			case 9:
				System.out.println("Enter the employee seniority to search");
				int seni = scn.nextInt();
				System.out.println(dao.getEmployeeSeniority(seni));
				break;
			case 10:
				System.out.println("Enter the employee Age to search ");
				System.out.println("Enter Min age");
				int min = scn.nextInt();
				System.out.println("Enter Max age");
				int max = scn.nextInt();
				System.out.println(dao.getEmployeeAgeBetween(min,max));
				break;
			default:
				System.out.println("Please enter a valid value");
				break;
			}
	}
}