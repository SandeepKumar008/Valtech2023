package employeeJspProject;

import java.sql.*;
import java.util.*;

public class DepartmentTable implements DepartmentDAO{
	
	static Scanner scn = new Scanner(System.in);

	public void deleteDepartment(int did) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("DELETE FROM DEPARTMENT WHERE ID=?");
		ps.setInt(1, did);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated:" + rowsUpdated);
		con.close();

	}

	public void updateDepartment(Department dep) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE EMPLOYEE SET DNAME = ?, DLOCATION = ? WHERE DID = ?");
		populatePreparedStatmentFromDepartment(dep, ps);
		ps.setInt(3, dep.getDid());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	public void createDepartment(Department dep) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO DEPARTMENT (DID,DNAME,DLOCATION) VALUES(?,?,?)");
		populatePreparedStatmentFromDepartment(dep, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows update:" + rowsUpdated);
		con.close();

	}

	private void populatePreparedStatmentFromDepartment(Department dep, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dep.getDid());
		ps.setString(2, dep.getDname());
		ps.setString(3, dep.getDlocation());
	
	}

	public List<Department> getAllDepartment() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT * FROM DEPARTMENT");
		ResultSet rs = ps.executeQuery();
		List<Department> deps = new ArrayList<>();
		while (rs.next()) {

			deps.add(mapRowToDepartment(rs));
		
		}

		con.close();
		return deps;

	}

	public Department getDepartment(int did) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT DID, DNAME,DLOCATION FROM DEPARTMENT WHERE DID=?");
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			Department d = mapRowToDepartment(rs);
			con.close();
			return d;

		} 
		else {

			System.out.println("No row with Id " + did + " found.");
			return null;

		}

	}
	
	public DepartmentJoin getEmployeeByDepartment(int did) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT EID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID, DNAME,DLOCATION FROM EMPLOYEE JOIN DEPARTMENT USING (DID) WHERE DID=?");
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			DepartmentJoin dj = mapRowToDepartmentEmp(rs);
			con.close();
			return dj;

		} 
		else {

			System.out.println("No row with Id " + did + " found.");
			return null;

		}

	}
	
	public List<DepartmentJoin> getEmployeeByLocation(String dlocation) throws SQLException {

		Connection con=getConnection();
		PreparedStatement ps=con
				.prepareStatement("SELECT EID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DID, DNAME,DLOCATION FROM EMPLOYEE JOIN DEPARTMENT USING (DID) WHERE DLOCATION=?");
		ps.setString(1, dlocation);
		ResultSet rs=ps.executeQuery();
		List<DepartmentJoin> dj =new ArrayList<>();

		while(rs.next()) {
			dj.add(mapRowToDepartmentEmp(rs));
		}
		con.close();
		return dj;
	}
	
	public List<GroupBy> getListofEmployeeinEachDepartment() throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT DNAME, GROUP_CONCAT(NAME) FROM EMPLOYEE JOIN DEPARTMENT USING (DID) GROUP BY DNAME");
		ResultSet rs = ps.executeQuery();
		List<GroupBy> gb = new ArrayList<>();
		while (rs.next()) {

			gb.add(mapRowToDepartmentEachEmp(rs));
		
		}

		con.close();
		return gb;

	}


	private DepartmentJoin mapRowToDepartmentEmp(ResultSet rs) throws SQLException {

		DepartmentJoin dj = new DepartmentJoin();
		dj.setEid(rs.getInt(1));
		dj.setName(rs.getString(2));
		dj.setAge(rs.getInt(3));
		dj.setExperience(rs.getInt(4));
		dj.setSeniority(rs.getInt(5));
		dj.setSalary(rs.getInt(6));
		dj.setDid(rs.getInt(7));
		dj.setDname(rs.getString(8));
		dj.setDlocation(rs.getString(9));
		return dj;

	}
	
	private GroupBy mapRowToDepartmentEachEmp(ResultSet rs) throws SQLException {

		GroupBy g = new GroupBy();
		g.setDname(rs.getString(1));
		g.setName(rs.getString(2));
		return g;

	}
	
	private Department mapRowToDepartment(ResultSet rs) throws SQLException {

		Department d = new Department();
		d.setDid(rs.getInt(1));
		d.setDname(rs.getString(2));
		d.setDlocation(rs.getString(3));
		return d;

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

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023", "root", "root");

	}

	public static void main(String[] args) throws SQLException {

		DepartmentDAO dao = new DepartmentTable();
		int ch;
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Update");
			System.out.println("4. Delete");
			System.out.println("5. Search");
			System.out.println("6. Get Employee By Department");
			System.out.println("7. Get Employee By Location");
			System.out.println("8. Get Employee By Department Name");
			System.out.println("Enter your choice:");
			ch = scn.nextInt();
			System.out.println("------------------------------------------------------------------------------");
			switch (ch) {
			case 1:
				System.out.println("Enter the Department details");
				System.out.println("Department ID : ");
				int did = scn.nextInt();
				System.out.println("Department Names : ");
				scn.nextLine();
				String dna = scn.nextLine();
				System.out.println("Department Location : ");
				String dlo = scn.nextLine();
				dao.createDepartment(new Department(did,dna,dlo));
				System.out.println(dao.getDepartment(did));
				break;
			case 2:
				System.out.println(dao.getAllDepartment());
				break;
			case 3:
				System.out.println("Enter the Department details");
				scn.nextLine();
				System.out.println("Department ID : ");
				int udid = scn.nextInt();
				System.out.println("Department Names : ");
				scn.nextLine();
				String udna = scn.nextLine();
				System.out.println("Department Location : ");
				scn.nextLine();
				String udlo = scn.nextLine();
				dao.updateDepartment(new Department(udid,udna,udlo));
				System.out.println(dao.getDepartment(udid));
				break;
			case 4:
				System.out.println("Enter the Department ID to delete");
				int de = scn.nextInt();
				dao.deleteDepartment(de);
				System.out.println("Department ID = "+de+" is been deleted");
				break;
			case 5:
				System.out.println("Enter the Department ID to search");
				int no = scn.nextInt();
				System.out.println(dao.getDepartment(no));
				break;
			case 6:
				System.out.println("Enter the Department ID to search for Employee details");
				int no1 = scn.nextInt();
				System.out.println(dao.getEmployeeByDepartment(no1));
				break;
			case 7:
				System.out.println("Enter the Department Loaction to search for Employee details");
				scn.nextLine();
				String dloc = scn.nextLine();
				System.out.println(dao.getEmployeeByLocation(dloc));
				break;
			case 8:
				System.out.println(dao.getListofEmployeeinEachDepartment());
				break;
			default:
				System.out.println("Please enter a valid value");
				break;
			}
	}

}