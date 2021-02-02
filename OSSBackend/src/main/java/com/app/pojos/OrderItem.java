package com.app.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="orderitems")
//@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderitem_id")
	private Integer id;

	@Column(nullable=false,name = "ItemDiscount")
	private double itemDiscount;

	@Column(nullable=false,name = "Quantity")
	private Integer quantity;

	@Column(nullable=false,name = "UnitPrice")
	private double unitPrice;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(targetEntity = Product.class,mappedBy="orderItem",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//@JsonManagedReference(value = "product_orderItem")
	private List<Product> products;
	
	//bi-directional many-to-one association to Order
	@ManyToOne()
	@JoinColumn(name="order_id",nullable=false)
	@JsonBackReference(value = "orderItem_order")
	private Order order;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, double itemDiscount, Integer quantity, double unitPrice, Order order, List<Product> products) {
		super();
		this.id = id;
		this.itemDiscount = itemDiscount;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.order = order;
		this.products=products;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getItemDiscount() {
		return this.itemDiscount;
	}

	public void setItemDiscount(double itemDiscount) {
		this.itemDiscount = itemDiscount;
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

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setOrderItem(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setOrderItem(null);

		return product;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemID=" + id + ", itemDiscount=" + itemDiscount + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", order=" + order + ", products=" + products + "]";
	}

}