package employeeJspProject;

public class DepartmentJoin extends DeclareVar {
	
	public DepartmentJoin() {
	}

	public DepartmentJoin(int eid, String name, int age, int experience, int seniority, int salary, int did, String dname, String dlocation) {
		this.eid = eid;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.did = did;
		this.dname = dname;
		this.dlocation = dlocation;
	}
	
	public String toString(){
		return "Employee_Details[eid=" + eid + ", name=" + name+", age=" + age +", experience=" + experience +", seniority=" + seniority + ", salary=" + salary + ",did="+did+", dname=" + dname+", dlocation=" + dlocation +"]\n";
	}

}
