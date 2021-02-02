package com.app.custom_excs;

public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(String mesg) {
		super(mesg);
	}
}
