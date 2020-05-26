package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateTest {
	public static void main(String[] args)throws Exception
	{
		PrivateDemo2 p=new PrivateDemo2();
		Class<?> classType=p.getClass();
		Object pdObj=classType.newInstance();
		
		Field[] fields=classType.getDeclaredFields();
		Field field=fields[0];
		field.setAccessible(true);
		
		field.set(pdObj, "Brew");
		System.out.println(p.getName());
			
//		String name=field.getName();
//		String getMethodName="get"+name.substring(0, 1).toUpperCase()+name.substring(1);
//			
//		Method getMethod=classType.getMethod(getMethodName, new Class[]{});
//			
//		System.out.println((String)getMethod.invoke(pdObj, new Object[]{}));
			
	}
}
