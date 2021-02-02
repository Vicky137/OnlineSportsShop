package com.app.pojos;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;

	@Column(length = 100,nullable=false,name = "Address")
	@NotBlank(message="address  can't be blank ")
	private String address;

	@Column(length = 45,unique=true,nullable=false,name = "ContactNumber")
	@NotBlank(message="Contact Number is must and should be unique ")
	private String contactNumber;

	@Column(length = 45,unique=true,nullable=false,name = "Email")
	@NotBlank(message="Email is must and should be unique ")
	private String email;

	@Column(length = 45,nullable=false,name = "CustomerName")
	//@JsonProperty(value = "customerName")
	@NotBlank(message="Customer name must be supplied ")
	private String name;

	@Column(length = 45,nullable=false,name = "Password")
	private String password;

	public Customer() {
		super();
	}

	public Customer(Integer id, String address, String contactNumber, String email, String name,
			String password) {
		super();
		this.id = id;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.name = name;
		this.password = password;

	}

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

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	@Override
	public String toString() {
		return "Customer [customerID=" + id + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", firstName=" + name + "]";
	}

}