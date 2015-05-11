package com.coop.crud.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coop.crud.modal.Priest;
import com.coop.crud.service.PriestService;
import com.coop.crud.servicelocator.ServiceLocator;

@Path("/priest")
public class PriestController {
	Logger log = LogManager.getLogger(PriestController.class.getName());
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Priest> getAllTodos(){
		PriestService priestService = null;
			priestService = ServiceLocator.instance().getTodoService();
			List<Priest> priests = priestService.getAllTodo();
			return priests;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Priest getAllTodos(@PathParam("id") String id){
		PriestService priestService = null;
			priestService = ServiceLocator.instance().getTodoService();
			Priest priest = priestService.find(id);
			return priest;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Priest updateToDo(@PathParam("id") String id, Priest priest) throws Exception {
		if(id == null){
			throw new Exception("is should not be null");
		}
		PriestService priestService = null;
		priest.setId(id);
		priestService = ServiceLocator.instance().getTodoService();
		priest = priestService.updateTodo(priest);
		return priest;
	}
}
