package com.app.custom_excs;

public class AdminNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(String mesg) {
		super(mesg);
	}
}
