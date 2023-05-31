package com.Java.bak.middle.Day04.src.com.zpark.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，其被代理对象必须实现一个接口(UserServiceIntf 和 UserServiceImpl)
 * */
public class ProxyUserService implements InvocationHandler {
	private UserServiceIntf us;

	public ProxyUserService(UserServiceIntf us) {
		this.us = us;
	}
	//获取代理对象的方法
	public UserServiceIntf getProxuObject() {
		UserServiceIntf proxyus = (UserServiceIntf) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				UserServiceImpl.class.getInterfaces(), this);
		return proxyus;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("开启事务");
		Object invoke = method.invoke(us, args);
		System.out.println("关闭事务");
		return invoke;
	}
}
