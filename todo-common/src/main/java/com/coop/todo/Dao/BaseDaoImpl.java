package com.coop.todo.Dao;

import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	private MongoDatabase db;
	private String collectionName;
	private MongoCollection<Document> coll;
	protected Gson gson = new GsonBuilder().create();
	
	public BaseDaoImpl(MongoDatabase db, String collectionName){
		this.db = db;
		this.collectionName = collectionName;
		this.coll = db.getCollection(this.collectionName);
	}

	public T Save(T obj) {
		coll.insertOne(new Document().parse(gson.toJson(obj)));
		return obj;
	}

	public T update(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public T delete(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findByValue(String Key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
