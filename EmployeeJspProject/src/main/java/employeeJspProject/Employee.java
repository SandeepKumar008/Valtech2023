package employeeJspProject;

public class Employee extends DeclareVar {
	
	public Employee() {
	}

	public Employee(int eid, String name, int age, int experience, int seniority, int salary, int did) {
		this.eid = eid;
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.did = did;
	}

	public Employee(String name, int age, int experience, int seniority, int salary, int did) {
		this.seniority = seniority;
		this.experience = experience;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.did = did;
	}
	
	@Override
	public String toString() {
		return "Employee[eid=" + eid + ", name=" + name+", age=" + age +", experience=" + experience +", seniority=" + seniority + ", salary=" + salary + ",did="+did+"]\n";
	}

}