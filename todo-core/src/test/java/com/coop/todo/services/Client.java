package com.coop.todo.services;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 Human h = (Human)AuditProxy.newInstance(new HumanImpl());
		 System.out.println(h.getName());
	}

}
