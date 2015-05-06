package com.coop.todo.Dao;

import com.mongodb.client.MongoDatabase;

public class TodoDaoImpl extends BaseDaoImpl implements TodoDao {

	private static String collectionName = "todo";
	private MongoDatabase db;
	
	public TodoDaoImpl(MongoDatabase db) {
		super(db, TodoDaoImpl.collectionName);
		this.db = db;
	}

	public void check() {
		// TODO Auto-generated method stub
		
	}
	

}
