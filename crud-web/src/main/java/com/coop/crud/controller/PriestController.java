package com.coop.crud.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coop.crud.controller.utils.WebUtils;
import com.coop.crud.exception.CustomException;
import com.coop.crud.modal.Priest;
import com.coop.crud.service.PriestService;
import com.coop.crud.servicelocator.ServiceLocator;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/priest")
public class PriestController {
	private static final Logger log = LogManager.getLogger(PriestController.class.getName());
	PriestService service = ServiceLocator.instance().getTodoService();
	
	@POST
	@Path("/save")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response savePriest(@FormDataParam("file") InputStream fileInput, 
			@FormDataParam("file") FormDataContentDisposition content){
		String filename = content.getFileName();
		log.error("file name : "+filename);
		String saveLocation = "/home/sankar/work/";
		saveLocation = saveLocation.concat(filename);
		try {
			WebUtils.uploadFile(fileInput, saveLocation);
		}catch (IOException e) {
			e.printStackTrace();
			log.error("error occ :"+filename);
			return Response.serverError().build();
		}
		return Response.ok(filename).build();
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPriest(){
		log.entry();
		List<Priest> priests = null;
		try{
			priests = service.getAllPriests();
		}catch(Exception e){
			log.catching(e);
			return Response.serverError().entity(e.getMessage()).build();
		}
		log.error("priests size is" +priests.size());
		return Response.status(200).entity(priests).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePriestProfile(Priest priest){
		log.entry();
		try{
			priest = service.updatePriest(priest);
		}catch(CustomException e){
			log.error("custom exception {} ", e.getMessage());
			return Response.status(412).entity(e.getMessage()).build();
		}catch(Exception e){
			log.error("custom exception {} ", e.getMessage());
			return Response.serverError().entity(e.getMessage()).build();
		}
		return Response.ok(priest).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePriest(@PathParam("id") String id){
		Priest priest = null;
		try {
			priest = service.deletePriest(id);
		} catch (CustomException e) {
			log.error("custom exception in delete {} ", e.getMessage());
			e.printStackTrace();
			return Response.serverError().entity(priest).build();
		}
		return Response.ok(priest).build();
	}
}
