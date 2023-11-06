package com.valtech.training.hibernate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BankAccount {
	@EmbeddedId
	private BankAccountId id;
	private double balance;
	public BankAccountId getId() {
		return id;
	}
	public void setId(BankAccountId id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(BankAccountId id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
