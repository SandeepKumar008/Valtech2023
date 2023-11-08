package com.valtech.training.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OrderSummaryId.class)
public class OrderSummary {
	@Id
	private int orderId;
	@Id
	private int ItemId;
	private int quantity;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderSummary(int orderId, int itemId, int quantity) {
		super();
		this.orderId = orderId;
		ItemId = itemId;
		this.quantity = quantity;
	}
	
	
	
	

}
