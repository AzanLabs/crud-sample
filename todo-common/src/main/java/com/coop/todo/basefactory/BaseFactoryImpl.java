package com.coop.todo.basefactory;

import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BaseFactoryImpl implements BaseFactory {
	
	
	private MongoDatabase db;
	protected String collectionName = "";
	private MongoCollection<Document> coll;
	
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

	public MongoDatabase getDb() {
		return db;
	}

	public void setDb(MongoDatabase db) {
		this.db = db;
	}

}
