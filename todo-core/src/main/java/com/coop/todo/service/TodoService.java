package com.coop.todo.service;

import java.util.List;

import com.coop.todo.modal.Todo;

public interface TodoService extends BaseService{
	
	public Todo createTodo(Todo todo) throws Exception;
	
	public Todo updateTodo(Todo todo) throws Exception;
	
	public Todo find(String id);
	
	public List<Todo> getAllTodo();
}
