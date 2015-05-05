package com.coop.todo.connections;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConnectionsImpl implements Connections {

	private final String user = "sankar";
	private final String pwd = "password";
	private final String host = "localhost";
	private final int port = 12345;
	private final String dbname = "test";
	
	public MongoDatabase getDBInstance() {
		MongoClient mClient = new MongoClient(host, port);
		MongoDatabase db = mClient.getDatabase(dbname);
		return db;
	}
	
}
