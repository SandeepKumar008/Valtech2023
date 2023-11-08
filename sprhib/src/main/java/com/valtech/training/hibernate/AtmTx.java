package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")
public class AtmTx extends Tx {
	
	private int atm;

	public AtmTx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AtmTx(float amount, int atm) {
		super(amount);
		this.atm = atm;
	}
	 

}
