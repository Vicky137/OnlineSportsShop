package com.app.custom_excs;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String mesg) {
		super(mesg);
	}
}
