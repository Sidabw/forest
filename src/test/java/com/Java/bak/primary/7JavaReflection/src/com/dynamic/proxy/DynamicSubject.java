package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {

	public Object obj;
	public DynamicSubject(Object obj)
	{
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("invoked befor the real request"+method);

		if("haha".equals(args[0])){
			Object iobj=method.invoke(obj, "aa");	
		}
		Object iobj=method.invoke(obj, args);

		System.out.println("Invoked after the real request"+ method);
		return iobj;
	}

}
