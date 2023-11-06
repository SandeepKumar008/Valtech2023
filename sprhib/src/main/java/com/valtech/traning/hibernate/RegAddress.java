package com.valtech.traning.hibernate;

import javax.persistence.Embeddable;

@Embeddable     // for embeding the entity into another class
public class RegAddress {
	
	private String street;
	private String city;
	private String Zip;
	
	
	
	public RegAddress(String street, String city, String zip) {
		super();
		this.street = street;
		this.city = city;
		Zip = zip;
	}
	public RegAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	
	

}
