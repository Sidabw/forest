package com.reflect;

import java.lang.reflect.Method;

public class InvokeTester {
	public static void main(String[] args) throws Exception
	{
		Class<?> classType=InvokeTester.class;
		//1.ps:只能够在构造方法不接受参数的时候使用，当构造方法接受参数时需要使用Constructor
		Object invokeTester=classType.newInstance();
		//2.
		Method method=classType.getMethod("add", new Class[]{int.class,int.class});
		Object result= method.invoke(invokeTester, new Object[]{1,2});
		System.out.println((Integer)result);
		
		Method method2=classType.getMethod("echo", new Class[]{String.class});
		//无论参数个数多少，都需要用Object[]
		Object result2=method2.invoke(invokeTester, new Object[]{"Sida"});
		System.out.println((String)result2);
	}
	public static int add(int param1,int param2)
	{
		//System.out.println(param1+"+"+param2+"="+(param1+param2));
		return param1+param2;
	}
	public static String echo(String value)
	{
		//System.out.println("Hello"+value);
		return "Hello"+"	"+value;
	}
}
