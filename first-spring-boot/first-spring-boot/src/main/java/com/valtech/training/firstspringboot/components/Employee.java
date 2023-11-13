package com.valtech.training.firstspringboot.components;

public class Employee {
	


	private int eid;
	private String name;
	private  int age;
	private  int experiance;
	private  int seniority;
	private  int salary;
	
	public Employee(String name, int age, int experince, int seniority, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.experiance = experince;
		this.seniority = seniority;
		this.salary= salary;
	}
	
	public Employee() {}

	public Employee(int eid, String name, int age, int experiance, int seniority, int salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.experiance = experiance;
		this.seniority = seniority;
		this.salary = salary;
	}



	public int geteid() {
		return eid;
	}

	public void seteid(int eid) {
		this.eid = eid;
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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age + ", experiance=" + experiance + ", seniority="
				+ seniority + ", salary=" + salary + "]";
	}

	
	
}