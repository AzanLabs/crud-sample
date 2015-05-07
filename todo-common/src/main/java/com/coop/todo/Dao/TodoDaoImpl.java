package com.coop.todo.Dao;

import com.mongodb.client.MongoDatabase;

public class TodoDaoImpl<T> extends BaseDaoImpl<T> implements TodoDao<T>{

	private static String collectionName = "todo";
	private MongoDatabase db;
	
	public TodoDaoImpl(MongoDatabase db) {
		super(db, TodoDaoImpl.collectionName);
		this.db = db;
	}	

}
