package com.coop.todo.service;

import com.coop.todo.modal.Todo;

public interface TodoService extends BaseService{
	
	public Todo createToDo(String todo) throws Exception;
}
