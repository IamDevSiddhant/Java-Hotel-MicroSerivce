package com.siddhant.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Hotel Details Not Found");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
