package com.valtech.traning.hibernate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int mobile;
	@Embedded
	private RegAddress regAddress;
	
	
	public Registration(String username, String password, int mobile, RegAddress regAddress) {
		super();
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.regAddress = regAddress;
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public RegAddress getRegAddress() {
		return regAddress;
	}
	public void setRegAddress(RegAddress regAddress) {
		this.regAddress = regAddress;
	}
	
	
	

}
