package com.coop.todo.Dao;

import java.util.List;

public interface BaseDao<T> {
	
	public T Save(T obj);
	
	public T update(T obj);
	
	public T delete(T obj);
	
	public T findById(int id);
	
	public List<T> findByValue(String Key, Object value);
	
}
