package com.coop.todo.service;

import java.util.List;

import com.coop.todo.dao.TodoDao;
import com.coop.todo.modal.Todo;

public class TodoServiceImpl implements TodoService {
	
	private TodoDao<Todo> dao = null;
	
	public TodoServiceImpl(TodoDao<Todo> dao) {
		this.dao = dao;
	}

	public Todo createTodo(Todo todo) throws Exception {
		System.out.println("entering service");
		try{
			todo = this.dao.SaveOne(todo);
		} catch(Exception e) {
			throw new Exception("exception caught on to do service "+e.getMessage());
		} finally {
			//DaoFactory.close();
		}
		return todo;
	}

	public Todo updateTodo(Todo todo) throws Exception {
		try{
			todo = this.dao.updateOne(todo);
		} catch(Exception e) {
			throw new Exception("exception caught on to do service "+e.getMessage());
		}
		return todo;
	}
	
	public List<Todo> getAllTodo() {
		return this.dao.findAll();
	}
	
	public Todo find(String id) {
		return this.dao.findById(id);
	}
}
