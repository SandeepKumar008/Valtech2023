 package com.valtech.training.hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;

public class OrderSummaryId implements Serializable {
	
	private int orderId;
	private int itamId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItamId() {
		return itamId;
	}
	public void setItamId(int itamId) {
		this.itamId = itamId;
	}
	
	public OrderSummaryId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderSummaryId(int orderId, int itamId) {
		super();
		this.orderId = orderId;
		this.itamId = itamId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itamId, orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderSummaryId other = (OrderSummaryId) obj;
		return itamId == other.itamId && orderId == other.orderId;
	}
	

}
