package com.coop.crud.service;

import com.coop.crud.exception.CustomException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			throw new CustomException("custom");
		}catch(CustomException e){
			System.out.println("here");
		}catch(Exception e){
			System.out.println("catching here");
		}
	}

}
