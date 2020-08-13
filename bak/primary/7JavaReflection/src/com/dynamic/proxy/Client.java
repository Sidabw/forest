package com.dynamic.proxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		com.dynamic.proxy.DynamicSubject dynamicSubject = new com.dynamic.proxy.DynamicSubject(realSubject);
		// s 即为$Proxy0动态代理类的对象
        // 生成代理实例，他需要一个ClassLoader（from InvocationHandler）,一系列的代理接口，InvocationHandler
        // 动态的生成1个代理类($Proxy0)及此代理类的实例，这个代理类宣称他实现了realSubject.getClass().getInterfaces()的一系列接口
		Class[] interfaces = { Subject.class };
		Subject s = (Subject) Proxy.newProxyInstance(dynamicSubject.getClass()
				.getClassLoader(), 
				interfaces, 
				dynamicSubject);
        // 方法调用，subject中的所有方法都会自动传递到handler中的invoke方法，参数列表为空，所有invoke中的Object[]
        // args为空
		s.request("haha");
		System.out.println(s.getClass().getName());
	}
}
