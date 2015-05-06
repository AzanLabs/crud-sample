package com.coop.todo.Dao;

import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BaseDaoImpl implements BaseDao {
	
	private MongoDatabase db;
	private String collectionName;
	private MongoCollection<Document> coll;
	
	public BaseDaoImpl(MongoDatabase db, String collectionName){
		this.db = db;
		this.collectionName = collectionName;
		this.coll = db.getCollection(this.collectionName);
	}
	
	public Object Save(Object obj) {
		 coll.insertOne(new Document("name","value"));
		 return obj;
	}

	public Object update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object delete(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> findByValue(String Key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDS(MongoDatabase db) {
		this.db = db;
		
	}

}
