package com.app.pojos;

public enum OrderStatus {
	CONFIRMED ,PLACED ,DELIVERED;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OrderStatus : "+name().toLowerCase();
	}
}
