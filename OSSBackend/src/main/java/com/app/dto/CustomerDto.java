package com.app.dto;

public class CustomerDto {

	private Integer id;

	private String address;

	private String cantactNumber;

	private String email;

	private String name;

	private String password;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer customerId) {
		this.id = customerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCantactNumber() {
		return this.cantactNumber;
	}

	public void setCantactNumber(String cantactNumber) {
		this.cantactNumber = cantactNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}