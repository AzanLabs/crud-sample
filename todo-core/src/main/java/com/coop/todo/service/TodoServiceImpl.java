package com.coop.todo.service;

import com.coop.todo.dao.TodoDao;
import com.coop.todo.modal.Todo;

public class TodoServiceImpl implements TodoService {
	
	private TodoDao<Todo> dao = null;
	
	public TodoServiceImpl(TodoDao<Todo> dao) {
		this.dao = dao;
	}

	public Todo createToDo(String todoStr) throws Exception {
		System.out.println("entering service");
		Todo todo = null;
		try{
			todo = new Todo();
			todo.setTitle(todoStr);
			todo = this.dao.Save(todo);
		} catch(Exception e) {
			throw new Exception("exception caught on to do service "+e.getMessage());
		} finally {
			//DaoFactory.close();
		}
		return todo;
	}
	
	
}
