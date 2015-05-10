package com.coop.todo.utils;

public class Validator {
	
	private static Validator validator = null;
	
	private Validator() {}
	
	public static Validator instance() {
		if(validator == null) {
			validator = new Validator();
		}
		return validator;
	}
	
	public Validator notNull(String param){
		return validator;
	}
}
