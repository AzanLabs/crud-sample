package com.coop.crud.dao;

import java.util.List;
/**
 * @author sankar
 * @param any Modal Object
 * @desc This interface provides the common methods to be implemented by daos
 */
public interface BaseDao<T> {
	
	public T SaveOne(T obj);
	
	public List<T> saveMany(List<T> objs);
	
	public T updateOne(T obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	
	public List<T> updateMany(List<T> objs);
	
	public T findById(Object id);
	
	public List<T> findAll();
}
