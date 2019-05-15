package com.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler  {
	private Object vecObj;
	public VectorProxy(Object obj)
	{
		this.vecObj=obj;
	}
	public static Object factory(Object obj)
	{
        //??vector???????
		Class<?> classType=obj.getClass();
		return Proxy.newProxyInstance(classType.getClassLoader(),classType.getInterfaces(),
				new VectorProxy(obj));
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("invoked before the real request");
		if(null!=args)
		{
			for(Object obj:args)
			{
				System.out.println(obj);
			}
		}
        /*
         * //?InvocationHandler API????invoke??????????
         * ?????????????????????????????????invoke??null???
         * NullPointException?????????ClassCastException???
         * */
		Object obj=method.invoke(vecObj, args);
		
		System.out.println("invoked after the real request");
		return obj;
	}
	public static void main(String[] args)
	{
		List v=(List)factory(new Vector());
		System.out.println(v.getClass().getName());	//?
		
		v.add("I Love Sida");
		v.add("Sida belongs to Brew");
		System.out.println(v);
		
		
	}
}
