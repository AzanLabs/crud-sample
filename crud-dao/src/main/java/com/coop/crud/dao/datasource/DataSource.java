package com.coop.crud.dao.datasource;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
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
		MongoCredential credentials = MongoCredential.createCredential("admin", "parishpriestcrud", 
				"mZPd7yM6981F".toCharArray());
		if(mClient == null) {
			//mClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credentials));
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
