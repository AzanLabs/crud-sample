package com.coop.todo.daofactory;

import com.coop.todo.dao.TodoDao;
import com.coop.todo.dao.TodoDaoImpl;
import com.coop.todo.datasource.DataSource;
import com.coop.todo.modal.Todo;
import com.mongodb.client.MongoDatabase;

public class DaoFactory {
	
	private MongoDatabase db = DataSource.getDBInstance();
	
	private static DaoFactory daoFactory = null;
	
	public static DaoFactory instance() {
		if(null == daoFactory) {
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}
	
	public TodoDao<Todo> getTodoDao() {
		return new TodoDaoImpl<Todo>(db);
	}
	
	public static void close(){
		DataSource.close();
	}
	
}
