package com.coop.todo.dao;

import com.mongodb.client.MongoCollection;

public class TodoDaoImpl<T> extends BaseDaoImpl<T> implements TodoDao<T>{

	private MongoCollection<T> coll = null;
	
	public TodoDaoImpl(MongoCollection<T> coll) {
		super(coll);
		this.coll = coll;
	}	

}
