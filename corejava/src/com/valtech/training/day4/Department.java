package com.valtech.training.day4;

public class Department {
	
		private int depId;
		private String depName;
		private String location;
		
	
	public Department() {}

	
	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + ", location=" + location + "]";
	}
	public Department(int deptID, String deptName, String location) {
		this.deptID = deptID;
		this.deptName = deptName;
		this.location = location;
	}
	
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


}
