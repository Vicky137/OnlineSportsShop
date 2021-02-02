package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer id;

	@Column(nullable=false,name = "Discount")
	private double discount;

	@Column(nullable=false,name = "GrandTotal")
	private double grandTotal;

	@Column(nullable=false,name = "OrderDate")
	private LocalDate orderDate;
	
	@Column(length = 45,nullable=false,name = "OrderStatus")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Column(length = 45,nullable=false,name = "ShipmentStatus")
	@Enumerated(EnumType.STRING)
	private ShipmentStatus shipmentStatus;

	@Column(nullable=false,name = "SubTotal")
	private double subTotal;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	@JsonManagedReference(value = "orderItem_order")
	private List<OrderItem> orderitems;

	//bi-directional many-to-one association to Customer
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id",nullable=false)
	//@JsonBackReference(value = "customer_order")
	//@JsonIgnoreProperties("orders")
	private Customer customer;

	public Order() {
		super();
	}

	public Order(Integer id, double discount, double grandTotal, LocalDate orderDate, OrderStatus orderStatus,
			ShipmentStatus shipmentStatus, double subTotal, List<OrderItem> orderitems, Customer customer) {
		super();
		this.id = id;
		this.discount = discount;
		this.grandTotal = grandTotal;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.shipmentStatus = shipmentStatus;
		this.subTotal = subTotal;
		this.orderitems = orderitems;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public List<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", discount=" + discount + ", grandTotal=" + grandTotal + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + ", shipmentStatus=" + shipmentStatus + ", subTotal=" + subTotal
				+ ", orderitems=" + orderitems + ", customer=" + customer + "]";
	}

}











