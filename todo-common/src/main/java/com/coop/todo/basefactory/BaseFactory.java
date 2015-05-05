package com.coop.todo.basefactory;

import java.util.List;

public interface BaseFactory {
	
	public Object Save(Object obj);
	
	public Object update(Object obj);
	
	public Object delete(Object obj);
	
	public Object findById(int id);
	
	public List<Object> findByValue(String Key, Object value);
	
}
