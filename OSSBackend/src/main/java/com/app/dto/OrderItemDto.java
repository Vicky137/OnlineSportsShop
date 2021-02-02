package com.app.dto;

public class OrderItemDto {

	private Integer id;

	private double itemDiscount;

	private Integer quantity;

	private double unitPrice;

	private Integer orderId;

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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}