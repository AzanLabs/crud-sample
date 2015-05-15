package com.coop.crud.controller;

import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.ImageIcon;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coop.crud.controller.utils.WebUtils;
import com.coop.crud.exception.CustomException;
import com.coop.crud.service.PriestService;
import com.coop.crud.servicelocator.ServiceLocator;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/image")
public class PriestImageController {
	
	private static final Logger log = LogManager.getLogger(PriestImageController.class.getName());
	PriestService service = ServiceLocator.instance().getPriestService();
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response saveImage(@FormDataParam("file") InputStream stream , 
			@FormDataParam("file") FormDataContentDisposition content, @FormDataParam("id") String id){
		String path = null;
		try{
			String saveLocation = "/home/sankar/uploads/";
			//checking for null values 
			WebUtils.isNotNull(stream, content, id);
			service.ifIdExists(id);
			String fileName = content.getFileName();
			log.error("fileName "+fileName);
			path = WebUtils.uploadFile(stream, saveLocation, id);
			log.error("path "+path);
			return Response.ok(path).build();
		}catch(CustomException e){
			e.printStackTrace();
			return Response.status(412).entity(e.getMessage()).build();
		}catch(Exception e){
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces("image/*")
	public Response getImage(@PathParam("id") String id){
		File file = null;
		try{
			String saveLocation = "/home/sankar/uploads/";
			WebUtils.isNotNull(id);
			service.ifIdExists(id);
			file = new File(saveLocation+id+".png");
			if(!file.exists()){
				throw new CustomException("file not found");
			}
			String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file);
			return Response.ok(file,contentType).build();
		}catch(CustomException e){
			e.printStackTrace();
			return Response.status(412).entity(e.getMessage()).build();
		}catch(Exception e){
			return Response.serverError().build();
		}
	}
	
}
