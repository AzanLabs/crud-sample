package com.coop.todo.servicelocator;

import com.coop.todo.dao.TodoDao;
import com.coop.todo.daofactory.DaoFactory;
import com.coop.todo.modal.Todo;
import com.coop.todo.service.TodoService;
import com.coop.todo.service.TodoServiceImpl;
/**
 * 
 * @author sankar
 * @desc This locator is responsible for locate and create instance of services, providing with it all needed dependencies.
 * 		 for more info see Martin Flower's blog on dependency injection and inversion of control
 * @return singleton serviceLocator Object
 */
public class ServiceLocator {
	
	//singleton instance of service Locator.
	private static ServiceLocator serviceLocator = null;
	
	
	private ServiceLocator(){}
	
	public static ServiceLocator instance() {
		if(null == serviceLocator) {//lazy loading service locator
			serviceLocator = new ServiceLocator();
		}
		return serviceLocator;
	}
	
	/**
	 * Below section contains methods for location and creation of services
	 * There will be at least one methods per service which handles its creation
	 */
	public TodoService getTodoService(){
		TodoDao<Todo> dao = DaoFactory.instance().getTodoDao();
		return new TodoServiceImpl(dao);
	}
	
}
