package com.app.dto;

import java.time.LocalDate;

import com.app.pojos.OrderStatus;
import com.app.pojos.ShipmentStatus;

public class OrderDto {

	private Integer id;

	private double discount;

	private double grandTotal;

	private LocalDate orderDate;

	private OrderStatus orderStatus;

	private ShipmentStatus shipmentStatus;

	private double subTotal;

	private Integer customerId;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getGrandTotal() {
		return this.grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public LocalDate getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}











