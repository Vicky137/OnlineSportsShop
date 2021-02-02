package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "category_id")
	@JsonProperty(value = "categoryId")
	private Integer id;
	
	@Column(length = 45,nullable=false,name = "CategoryName")
	@JsonProperty(value = "categoryName")
	@NotBlank(message="Category name must be supplied ")
	private String name;
	
	@Column(name = "AsscociatedSport",length = 45,nullable=false)
	@NotBlank(message="Asscociated Sport must be supplied ")
	private String asscociatedSport;
	
	@Column(name = "Brand",length = 45,nullable=false)
	@NotBlank(message="Brand must be supplied ")
	private String brand;
	
	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	@JsonManagedReference(value="product_category")
	private List<Product> products;

	public Category() {
		super();
	}
	

	public Category(Integer id, String name, String asscociatedSport, String brand, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.asscociatedSport = asscociatedSport;
		this.brand = brand;
		this.products = products;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsscociatedSport() {
		return this.asscociatedSport;
	}

	public void setAsscociatedSport(String asscociatedSport) {
		this.asscociatedSport = asscociatedSport;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + id + ", categoryName=" + name + ", asscociatedSport=" + asscociatedSport + ", brand=" + brand
				+ ", products=" + products + "]";
	}
	
}