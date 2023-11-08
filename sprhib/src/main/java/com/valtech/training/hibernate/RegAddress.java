package com.valtech.training.hibernate;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
//it means it can be embedded inside another entity
public class RegAddress {
	private String street;
	private String city;
	private String zipcode;

	
	
	
	public RegAddress() {}
	
	public RegAddress(String street, String city, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	


}
