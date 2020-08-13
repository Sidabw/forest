package com.Java.bak.middle.Day04.src.com.zpark.proxy;

public class Test {

	public static void main(String[] args){
/*		//创建被代理对象
		UserServiceImpl us = new UserServiceImpl();
		//创建代理对象
		ProxyUserService px = new ProxyUserService(us);
		//完成代理
		UserServiceIntf proxuObject = px.getProxuObject();
		//调用被代理对象的方法(已经加强)
		proxuObject.add();*/
		
		
		//方式二cglib代理
		//创建代理类对象
		ProxyUserService2 proxyUserService2 = new ProxyUserService2();
		//获取被代理对象
		UserServiceImpl proxyObject = proxyUserService2.getProxyObject();
		//调用方法（已经加强）
		proxyObject.add();
		System.out.println(proxyObject instanceof UserServiceImpl);
	}
}
