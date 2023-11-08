package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ctx")
public class ChequeTx extends Tx {
	
	private int chequeNum;
	private int micr;
	
	
	
	public ChequeTx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChequeTx(float amount, int chequeNum, int micr) {
		super(amount);
		this.chequeNum = chequeNum;
		this.micr = micr;
	}
	public int getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(int chequeNum) {
		this.chequeNum = chequeNum;
	}
	public int getMicr() {
		return micr;
	}
	public void setMicr(int micr) {
		this.micr = micr;
	}

}
