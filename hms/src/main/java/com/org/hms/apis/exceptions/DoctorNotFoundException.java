package com.org.hms.apis.exceptions;

public class DoctorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException(String message) {
		super(message);
	}
}
