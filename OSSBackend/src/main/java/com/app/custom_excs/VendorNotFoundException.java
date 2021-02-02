package com.app.custom_excs;

public class VendorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VendorNotFoundException(String mesg) {
		super(mesg);
	}
}
