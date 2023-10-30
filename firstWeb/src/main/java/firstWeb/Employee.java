package firstWeb;


public class Employee {
	
	private int id;
	private String name;
	private  int age;
	private  int experiance;
	private  int seniority;
	private  int salary;
	private int department_id;
	
	public Employee() {}
	
	public Employee(int id, String name, int age, int experiance, int seniority, int salary, int department_id) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.experiance = experiance;
		this.seniority = seniority;
		this.salary = salary;
		this.department_id = department_id;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", experiance=" + experiance + ", seniority="
				+ seniority + ", salary=" + salary + ", department_id=" + department_id + "]";
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getExperiance() {
		return experiance;
	}


	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}


	public int getSeniority() {
		return seniority;
	}


	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}






//	public Employee(String name, int age, int experiance, int seniority, int salary,int department_id) {
//		this.name = name;
//		this.age = age;
//		this.experiance = experiance;
//		this.seniority = seniority;
//		this.salary = salary;
//		this.department_id(department_id);
//	}
//	
//	public Employee(int id, String name, int age, int experiance, int seniority, int salary,int department_id) {
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.experiance = experiance;
//		this.seniority = seniority;
//		this.salary = salary;
//		this.department_id(department_id);
//		
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", experiance=" + experiance + ", seniority="
//				+ seniority + ", salary=" + salary + "]";
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public int getAge() {
//		return age;
//	}
//
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//
//	public int getExperiance() {
//		return experiance;
//	}
//
//
//	public void setExperiance(int experiance) {
//		this.experiance = experiance;
//	}
//
//
//	public int getSeniority() {
//		return seniority;
//	}
//
//
//	public void setSeniority(int seniority) {
//		this.seniority = seniority;
//	}
//
//
//	public int getSalary() {
//		return salary;
//	}
//
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//
//
//
//
//	public int getDepartment_id() {
//		return department_id;
//	}
//
//
//	public void setDepartment_id(int department_id) {
//		this.department_id = department_id;
//	}



	

}
