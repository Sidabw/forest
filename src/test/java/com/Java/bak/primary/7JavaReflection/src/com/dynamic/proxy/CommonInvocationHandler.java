package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHandler implements InvocationHandler {

	public Object target;
	public CommonInvocationHandler() {
		// TODO Auto-generated constructor stub
	}
	public CommonInvocationHandler(Object obj) {
		// TODO Auto-generated constructor stub
		this.target=obj;
	}
	public void setTarget(Object obj)
	{
		this.target=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if(target instanceof FooImpl){
			System.out.println("FooImpl is going to invoke");
		}else if (target instanceof FooImpl2){
			System.out.println("FooImpl2 is going to invoke");
		}
		return method.invoke(target, args);
	}

}
