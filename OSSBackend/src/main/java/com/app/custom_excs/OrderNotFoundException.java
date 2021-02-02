package com.app.custom_excs;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String mesg) {
		super(mesg);
	}
}
