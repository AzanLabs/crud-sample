package com.coop.crud.dao;

import com.mongodb.client.MongoCollection;

public class PriestDaoImpl<T> extends BaseDaoImpl<T> implements PriestDao<T>{

	private MongoCollection<T> coll = null;
	
	public PriestDaoImpl(MongoCollection<T> coll) {
		super(coll);
		this.coll = coll;
	}	

}
