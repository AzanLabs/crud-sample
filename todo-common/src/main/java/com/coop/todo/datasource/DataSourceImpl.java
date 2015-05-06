package com.coop.todo.datasource;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DataSourceImpl implements DataSource {

	//private static final String user = "sankar";
	//private static final String pwd = "password";
	private static final String host = "localhost";
	private static final int port = 12345;
	private static final String dbname = "test";
	
	private MongoClient mClient;
	
	public MongoDatabase getDBInstance() {
		mClient = new MongoClient(DataSourceImpl.host, DataSourceImpl.port);
		MongoDatabase db = mClient.getDatabase(DataSourceImpl.dbname);
		return db;
	}

	public void close() {
		if(null != mClient) {
			mClient.close();
		}
	}
	
}
