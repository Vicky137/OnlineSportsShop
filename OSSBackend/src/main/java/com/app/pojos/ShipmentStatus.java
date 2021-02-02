package com.app.pojos;

public enum ShipmentStatus {
	SHIPPING , INTRANSIT,SHIPPED ;
	
	@Override
	public String toString() {
		
		return "ShipmentStatus : "+name().toLowerCase();
	}

}
