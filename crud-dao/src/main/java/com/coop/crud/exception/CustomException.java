package com.coop.crud.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomException(String msg) {
		super(msg);
	}
	
	public CustomException(Exception e) {
		super(e);
	}
	
	public CustomException(String msg, Exception e) {
		super(msg, e);
	}

}
