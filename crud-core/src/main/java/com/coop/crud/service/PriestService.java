package com.coop.crud.service;

import java.util.List;

import com.coop.crud.modal.Priest;

public interface PriestService extends BaseService{
	
	public Priest createTodo(Priest priest) throws Exception;
	
	public Priest updateTodo(Priest priest) throws Exception;
	
	public Priest find(String id);
	
	public List<Priest> getAllTodo();
}
