package com.Java.bak.middle.Day04.src.com.zpark.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyUserService2 implements MethodInterceptor{

	public UserServiceImpl getProxyObject(){
		//创建核心对象
		Enhancer en = new Enhancer();
		//设置父类
		en.setSuperclass(UserServiceImpl.class);
		//做什么
		en.setCallback(this);
		//得到代理对象
		UserServiceImpl us = (UserServiceImpl) en.create();
		return us;
	}
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("开启事务");
		Object invokeSuper = methodProxy.invokeSuper(arg0, arg2);
		System.out.println("关闭事务");
		return invokeSuper;
	}

}
