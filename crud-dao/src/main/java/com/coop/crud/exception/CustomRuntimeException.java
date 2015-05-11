package com.coop.crud.exception;

public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CustomRuntimeException(String msg) {
		super(msg);
	}
	
	public CustomRuntimeException(Exception e) {
		super(e);
	}
	
	public CustomRuntimeException(String msg, Exception e) {
		super(msg, e);
	}
}
