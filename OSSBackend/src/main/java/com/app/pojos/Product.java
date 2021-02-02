package com.app.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;

	@Column(length = 200,name = "Description")
	private String description;

	@Column(length = 45,nullable=false,name = "ProductName")
	@JsonProperty(value = "productName")
	@NotBlank(message="Product name must be supplied ")
	private String name;

	@Column(nullable=false,name = "Quantity")
	private Integer quantity;

	@Column(nullable=false,name = "UnitPrice")
	private double unitPrice;
	
	@Column(length = 80,nullable=false,name = "ImageUrl")
	private String imageUrl;

	//bi-directional many-to-one association to Order
	@ManyToOne()
	@JoinColumn(name="orderitem_id")
	//@JsonBackReference(value = "product_orderItem")
	@JsonIgnore
	private OrderItem orderItem;
	
	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	@JsonBackReference(value="product_category")
	private Category category;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="vendor_id",nullable=false)
	@JsonBackReference(value = "vendor_product")
	//@JsonIgnoreProperties("products")
	private Vendor vendor;

	public Product() {
		super();
	}

	public Product(Integer id, String description, String name, Integer quantity, double unitPrice, String imageUrl,
			List<Order> orders, OrderItem orderItem, Category category, Vendor vendor) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.orderItem = orderItem;
		this.category = category;
		this.vendor = vendor;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String productName) {
		this.name = productName;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public OrderItem getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [productID=" + id + ", description=" + description + ", productName=" + name
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", imageUrl=" + imageUrl + ", orderItems=" + orderItem + ", category="
				+ category + ", vendor=" + vendor + "]";
	}

}