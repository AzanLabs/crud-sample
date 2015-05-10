package com.coop.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		String path = request.getPathInfo();
		logger.error(path);
		try {
			TodoService todoService = ServiceLocator.instance().getTodoService();
			response.setContentType("application/json");
			response.setStatus(200);
			if(path == null)
			{
				
				List<Todo> todos = todoService.getAllTodo();
				out.write(gson.toJson(todos));
			}
			else
			{
				String id = path.substring(1);
				if(id == null){
					throw new Exception("missing param id");
				}
				Todo todo = todoService.find(id);
				out.write(gson.toJson(todo));
			}
			
		} catch(Exception e) {
			logger.catching(e);
			response.sendError(400, e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.entry(request);
		PrintWriter out = response.getWriter();
		String path = request.getPathInfo();
		logger.error(path);
		try {
			if(path != null){
				throw new Exception("bad url");
			}
			String title = request.getParameter("title"); 
			String content = request.getParameter("content");
			if(title == null || content == null) {
				throw new Exception("tiltle and content are mandatory params");
			}
			Todo todo = new Todo();
			todo.setTitle(title);
			todo.setContent(content);
			 
			response.setContentType("application/json");
			response.setStatus(200);
			
			TodoService todoService = ServiceLocator.instance().getTodoService();
			todo = todoService.createTodo(todo);
			out.write(gson.toJson(todo));
		} catch(Exception e) {
			logger.catching(e);
			response.sendError(400, e.getMessage());
		}
	}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.entry(request);
		PrintWriter out = response.getWriter();
		String path = request.getPathInfo();
		logger.error(path);
		try {
			if(path == null){
				throw new Exception("id param not present");
			}
			String id = path.substring(1);
			String title = request.getParameter("title"); 
			String content = request.getParameter("content");
			Boolean isTrash = new Boolean(request.getParameter("isTrash"));
			Boolean isCompleted = new Boolean(request.getParameter("isCompleted"));
			
			Todo todo = new Todo();
			todo.setId(id);
			todo.setTitle(title);
			todo.setContent(content);
			todo.setCompleted(isCompleted);
			todo.setTrash(isTrash);
			 
			response.setContentType("application/json");
			response.setStatus(200);
			
			TodoService todoService = ServiceLocator.instance().getTodoService();
			todo = todoService.updateTodo(todo);
			out.write(gson.toJson(todo));
		} catch(Exception e) {
			logger.catching(e);
			response.sendError(400, e.getMessage());
		}
	}

}
