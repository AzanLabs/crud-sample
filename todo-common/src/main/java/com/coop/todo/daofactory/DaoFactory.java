package com.coop.todo.daofactory;

import com.coop.todo.Dao.TodoDao;
import com.coop.todo.Dao.TodoDaoImpl;
import com.coop.todo.datasource.DataSource;
import com.coop.todo.datasource.DataSourceImpl;
import com.mongodb.client.MongoDatabase;

public class DaoFactory {
	
	private DataSource ds = new DataSourceImpl();
	
	private MongoDatabase db = (MongoDatabase) ds.getDBInstance();
	
	private static DaoFactory daoFactory = null;
	
	public static DaoFactory instance() {
		if(null == daoFactory) {
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}
	
	public TodoDao getTodoDao() {
		return new TodoDaoImpl(db);
	}
	
	public void close(){
		this.ds.close();
	}
	
}
