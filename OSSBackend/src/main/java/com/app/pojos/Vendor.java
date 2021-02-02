package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity
@Table(name="vendors")
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	@JsonProperty(value = "vendorId")
	private Integer id;

	@Column(length = 45,unique=true,nullable=false,name = "ContactNumber")
	@NotBlank(message="Cantact Number must be valid ")
	private String contactNumber;

	@Column(length = 45,unique=true,nullable=false,name = "Email")
	@NotBlank(message="Email must be valid ")
	private String email;

	@Column(length = 45,nullable=false,name = "vendor_name")
	@JsonProperty(value = "vendorName")
	@NotBlank(message="Vendor name must be supplied ")
	private String name;

	@Column(length = 45,unique=true,nullable=false,name = "StoreName")
	@NotBlank(message="Store name must be supplied ")
	private String storeName;
	
	@Column(length = 45,nullable=false,name = "Password")
	private String password;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="vendor",cascade=CascadeType.ALL)
	@JsonManagedReference(value = "vendor_product")
	@JsonIgnoreProperties("products")
	private List<Product> products;

	public Vendor() {
		super();
	}

	public Vendor(Integer id, String contactNumber, String email, String password, String name,
			String storeName, List<Product> products) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.name = name;
		this.storeName = storeName;
		this.products = products;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setVendor(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setVendor(null);

		return product;
	}

	@Override
	public String toString() {
		return "Vendor [vendorID=" + id + ", contactNumber=" + contactNumber + ", email=" + email + ", firstName="
				+ name + ", storeName=" + storeName + ", products=" + products + "]";
	}

}