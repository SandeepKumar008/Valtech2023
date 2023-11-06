package com.valtech.traning.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ctx")
public class ChequeTx extends Tx {
	
	private int chequeNUm;
	private int micr;
	
	

	
	public ChequeTx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChequeTx(float amount, int chequeNUm, int micr) {
		super(amount);
		this.chequeNUm = chequeNUm;
		this.micr = micr;
	}
	public int getChequeNUm() {
		return chequeNUm;
	}
	public void setChequeNUm(int chequeNUm) {
		this.chequeNUm = chequeNUm;
	}
	public int getMicr() {
		return micr;
	}
	public void setMicr(int micr) {
		this.micr = micr;
	}
	
	

}
