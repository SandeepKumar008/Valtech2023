package com.valtech.training.hibernate;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "xyz")
//	@SequenceGenerator(name = "xyz",sequenceName = "empseeq")
//	@Id @GeneratedValue(strategy = GenerationType.TABLE,generator = "abc")
//	@TableGenerator(name = "abc",table = "pktable",pkColumnName = "PKcol",
//	pkColumnValue = "empseq",valueColumnName = "seed")
	
	private int id; //log id
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", gender=" + gender
				+ ", active=" + active + ", version=" + version + "]";
	}
	private String name;
	@Basic() @Temporal(TemporalType.DATE)
	private Date dob;
	private float salary;
	private char gender;
	private boolean active;
	@Version
	private int version;
	
	
	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public Employee() {}     //paremeter less constructor
	
	
	
	public Employee(int id, String name, Date dob, float salary, char gender, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
	}
	
	public Employee(String name, Date dob, float salary, char gender, boolean active) {
		super();
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}
