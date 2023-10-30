package com.valtech.training.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

	public static void main(String[] args) throws SQLException {
		DepartmentDAO ddao = new DepartmentDAOImpl();
		System.out.println("here it is");
		ddao.addDepartment(new Department(2,"Sales","Bangalore Bangalore west"));
//		System.out.println(ddao.getAllDepartments());

		
	}

	@Override
	public long count() throws SQLException {
		
		return 0;
	}

	@Override
	public void deleteDepartment(int deptID) throws SQLException {
		Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM DEPARTMENT WHERE deptID = ?");
        ps.setInt(1, deptID);
        int rowsUpdated = ps.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
        conn.close();
    }
	

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE DEPARTMENT SET DeptID = ?,DEPNAME = ?, LOCATION = ? WHERE DEPID = ?");
        ps.setInt(1, dept.getDeptID());
        ps.setString(1, dept.getDeptName());
        ps.setString(2, dept.getLocation());
        ps.setInt(3, dept.getDeptID());
        int rowsUpdated = ps.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
        conn.close();
    }
	
	

	@Override
	public void addDepartment(Department dept) throws SQLException {
		Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO DEPARTMENT(deptID,deptName,location) VALUES (?,?,?)");
        ps.setInt(1, dept.getDeptID());
        ps.setString(2, dept.getDeptName());
        ps.setString(3, dept.getLocation());
        int rowsUpdated = ps.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
        conn.close();
	}

	@Override
	public Department getDepartment(int deptID) throws SQLException {
		Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT deptID, deptname, location FROM Department WHERE deptID = ?");
        ps.setInt(1, deptID);
        ResultSet rs = ps.executeQuery();
        Department dept = null;
        if (rs.next()) {
            dept = mapRowToDepartment(rs);
        }
        conn.close();
        return dept;
	}

	@Override
	public List<Department> getAllDepartments() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT deptID,deptName,location FROM DEPARTMENT");
        ResultSet rs = ps.executeQuery();
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            departments.add(mapRowToDepartment(rs));
        }
        conn.close();
        return departments;
	}

	@Override
	public List<Employee> getAllEmployeesByDepartment(int deptID) throws SQLException {
		return null;
	}
	
	   private Department mapRowToDepartment(ResultSet rs) throws SQLException {
	        int deptID = rs.getInt("deptID");
	        String deptName = rs.getString("deptName");
	        String location = rs.getString("location");
	        return new Department(deptID, deptName, location);
	    }
	
	
	private Connection getConnection() throws SQLException {
        // Replace with your database connection details
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
    }

}
