package com.reflect;

import java.lang.reflect.Method;

public class DumpDemo  {
	public static void main(String[] args)throws Exception
	{
		//dump	À¬»ø³¡
		Class<?> classType=Class.forName("java.lang.String");
		Method[] methods=classType.getDeclaredMethods();
		for(Method method:methods)
		{
			System.out.println(method);
		}
	}
	
}
