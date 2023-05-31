package com.exceptiontest;

public class ExceptionDemo {
	public static void func()
	{
		try
		{
			throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println("B");
		}
	}

	public static void main(String[] args)
	{
		try
		{
			func();
		}
		catch(Exception e)
		
		{
			System.out.println("C");
		}
		System.out.println("D");
		
		
	}
}
