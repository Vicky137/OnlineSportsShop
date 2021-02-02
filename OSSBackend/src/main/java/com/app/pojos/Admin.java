package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="admins")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(length = 45,unique=true,nullable=false,name = "Email")
	@NotBlank(message="Email is must and unique ")
	private String email;

	@Column(length = 45,nullable=false,name = "Password")
	private String password;
	
	@Column(length = 45,nullable=false,name = "Name")
	//@JsonProperty(value = "adminName")
	@NotBlank(message="Admin name must be supplied ")
	private String name;

	public Admin() {
		super();
	}
	

	public Admin(Integer id, String email, String password, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Credential [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	

}