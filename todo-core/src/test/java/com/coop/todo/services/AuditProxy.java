package com.coop.todo.services;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AuditProxy implements InvocationHandler {
	
	private Object obj = null;
	
	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AuditProxy(obj));
	}
	
	private AuditProxy(Object obj){
		this.obj = obj;
	}
	public Object invoke(Object proxy, Method m, Object[] arg)
			throws Throwable {
		Object result = null;
		try{
			System.out.println("start time"+System.nanoTime());
			result = m.invoke(proxy, arg);
			System.out.println("end time"+System.nanoTime());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return result;
	}

}
