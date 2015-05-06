package com.coop.todo.service;

import com.coop.todo.Dao.TodoDao;
import com.coop.todo.modal.Todo;

public class TodoServiceImpl implements TodoService {
	
	private TodoDao dao = null;
	
	public TodoServiceImpl(TodoDao dao) {
		this.dao = dao;
	}
	
	
	public Todo createTodo(Todo todo){
		this.dao.check();
		return (Todo) this.dao.Save(todo);
	}
}
