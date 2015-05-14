package com.coop.crud.controller.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WebUtils {
	
	public static void uploadFile(InputStream in, String path) throws IOException{
		OutputStream out = null;
		File file = null;
		try{
			file = new File(path);
			out = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];	 
			while((read = in.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error while uploading file");
		}finally{
			System.out.println("clean exit");
		}
	}
}
