package com.coop.todo.datasource;

public interface DataSource {
	
	public Object getDBInstance();
	
	public void close();
}
