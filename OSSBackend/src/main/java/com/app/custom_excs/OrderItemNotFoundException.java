package com.app.custom_excs;

public class OrderItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(String mesg) {
		super(mesg);
	}
}
