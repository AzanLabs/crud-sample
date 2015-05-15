package com.coop.crud.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PriestClient {

	
	public static void main(String[] args) throws IOException{
		String saveLocation = "../../uploads/";
		File file = new File(saveLocation);
		if(!file.exists()){
			file.mkdirs();
		}
		saveLocation = saveLocation.concat("a.log");
		file = new File(saveLocation);
		FileWriter out = new FileWriter(file);
		out.write("hai how r u");
		out.flush();
		out.close();
		System.out.println(file.getAbsolutePath());
	}		
}
