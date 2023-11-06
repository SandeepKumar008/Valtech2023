package com.valtech.traning.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")

public class AtmTx extends Tx {
	
	
	private int atm;

	

	public AtmTx(float amount, int atm) {
		super(amount);
		this.atm = atm;
	}

	public AtmTx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}
	
	
	

}
