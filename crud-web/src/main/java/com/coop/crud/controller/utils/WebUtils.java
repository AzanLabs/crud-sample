package com.coop.crud.controller.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;

import com.coop.crud.exception.CustomException;

public class WebUtils {
	
	public static String uploadFile(InputStream in, String path, String id) throws IOException{
		OutputStream out = null;
		File file = null;
		try{
			file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			path = path.concat(id+".png");
			file = new File(path);
			out = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];	 
			while((read = in.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error while uploading file");
		}finally{
			in.close();
			out.flush();
			out.close();
			System.out.println("clean exit");
		}
		return file.getCanonicalPath();
	}
	
	public static void isNotNull(Object... objs) throws CustomException{
		for(int i = 0; i < objs.length; i++){
			if(objs[i] == null){
				throw new CustomException("params expected , got null value");
			}
		}
	}
	
	public static void validateEntry(Object obj, String... fields) throws Exception{
		Object value = null;
		for(int i = 0; i < fields.length; i++){
			value = PropertyUtils.getProperty(obj, fields[i]);
			if(value == null){
				throw new CustomException(fields[i]+" should not be null");
			}
		}
		
	}
}
