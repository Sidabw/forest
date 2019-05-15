package com.dynamic.proxy;

import java.lang.reflect.Proxy;

public class FooDemo {
	public static void main(String[] args) {
		FooImpl f=new FooImpl();
		CommonInvocationHandler handler=new CommonInvocationHandler(f);
		Foo fo1=(Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, handler);
		fo1.doAction();
		
		handler.setTarget(new FooImpl2());
		Foo fo2=(Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, handler);
		fo2.doAction();
		
	}
}
