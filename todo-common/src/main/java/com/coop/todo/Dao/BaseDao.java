package com.coop.todo.Dao;

import java.util.List;

import com.mongodb.client.MongoDatabase;

public interface BaseDao {
	
	public void setDS(MongoDatabase db);
	
	public Object Save(Object obj);
	
	public Object update(Object obj);
	
	public Object delete(Object obj);
	
	public Object findById(int id);
	
	public List<Object> findByValue(String Key, Object value);
	
}
