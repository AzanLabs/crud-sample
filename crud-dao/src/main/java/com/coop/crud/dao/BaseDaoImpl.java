package com.coop.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.coop.crud.exception.CustomException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.UpdateResult;

/**
 * @author sankar
 * @param <T> any modal object
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	protected MongoCollection<T> coll = null;
	
	public BaseDaoImpl() {}
	
	public BaseDaoImpl(MongoCollection<T> coll) {
		this.coll = coll;
	}
	
	public T SaveOne(T obj) {
		this.coll.insertOne(obj);
		return obj;
	}

	public List<T> saveMany(List<T> objs) {
		this.coll.insertMany(objs);
		return objs;
	}

	public T updateOne(T obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, CustomException {
		FindOneAndUpdateOptions options = new FindOneAndUpdateOptions();
		options.returnDocument(ReturnDocument.AFTER);
		options.upsert(false);
		obj = this.coll.findOneAndUpdate(Filters.eq("id", obj.getClass().getField("id").get(obj)), 
				new Document("$set",obj), options);
		if(obj == null){
			throw new CustomException("Can't update. the object with the given id doesnot exists");
		}
		return obj;
	}

	public List<T> updateMany(List<T> objs) {
		//this.coll.updateOne(Filters.eq("id", objs.get(0).getClass().getField("id").get(obj.get)), new Document("$set",obj));
		return objs;
	}

	public T findById(Object id) throws CustomException {
		T t = this.coll.find(Filters.eq("id",id)).first();
		if(t == null){
			throw new CustomException("The Object with the given id doesnot exists");
		}
		return t;
	}

	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		return this.coll.find().into(list);
	}

	@Override
	public T deleteOne(String id) throws CustomException {
		T t = null;
		t = this.coll.findOneAndDelete(Filters.eq("id", id));
		if(t == null){
			throw new CustomException("Can't delete object , object does not exists");
		}
		return t;
	}
	
	
	
}
