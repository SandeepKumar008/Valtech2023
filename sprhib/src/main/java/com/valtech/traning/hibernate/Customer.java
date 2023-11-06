package com.valtech.traning.hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	@OneToOne(targetEntity = Address.class,cascade = {CascadeType.MERGE,CascadeType.REMOVE}, fetch =FetchType.LAZY , mappedBy = "customer" )
	
	private Address address;
	
	@ManyToMany(targetEntity = Account.class,fetch = FetchType.LAZY,mappedBy = "customers")
	private Set<Account> accounts;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public Customer( String name, int age) {
		super();
		
		this.name = name;
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	
}
