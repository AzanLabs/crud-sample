package com.coop.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.coop.todo.modal.Todo;
import com.coop.todo.service.TodoService;
import com.coop.todo.servicelocator.ServiceLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TodoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(TodoController.class);
	private static final Gson gson = new GsonBuilder().create();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.entry(request);
		PrintWriter out = response.getWriter();
		try {
			String title = request.getParameter("title"); 
			response.setContentType("application/json");
			response.setStatus(200);
			TodoService todoService = ServiceLocator.instance().getTodoService();
			Todo todo = todoService.createToDo(title);
			out.write(gson.toJson(todo));
		} catch(Exception e) {
			logger.catching(e);
			response.sendError(400, e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.entry(request);
		PrintWriter out = response.getWriter();
		try {
			String title = request.getParameter("title"); 
			response.setContentType("application/json");
			response.setStatus(200);
			TodoService todoService = ServiceLocator.instance().getTodoService();
			Todo todo = todoService.createToDo(title);
			out.write(gson.toJson(todo));
		} catch(Exception e) {
			logger.catching(e);
			response.sendError(400, e.getMessage());
		}
	}

}
