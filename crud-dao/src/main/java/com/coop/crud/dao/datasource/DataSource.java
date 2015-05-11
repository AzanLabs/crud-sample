package com.coop.crud.dao.datasource;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DataSource{

	//private static final String user = "sankar";
	//private static final String pwd = "password";
	private static final String host = "localhost";
	private static final int port = 12345;
	private static final String dbname = "test";
	
	private static MongoClient mClient;
	
	public static MongoDatabase getDBInstance() {
		MongoDatabase db = null;
		if(mClient == null) {
			mClient = new MongoClient(DataSource.host, DataSource.port);
			db = mClient.getDatabase(DataSource.dbname);
		}
		return db;
	}

	public static void close() {
		if(mClient != null) {
			mClient.close();
		}
	}
	
}
