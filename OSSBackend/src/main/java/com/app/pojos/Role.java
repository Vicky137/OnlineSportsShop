package com.app.pojos;

public enum Role {
	ADMIN , CUSTOMER , VENDOR;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Role : "+name().toLowerCase();
	}
}
