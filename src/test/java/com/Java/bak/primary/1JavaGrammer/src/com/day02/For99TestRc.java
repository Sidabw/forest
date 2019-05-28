package com.day02;

public class For99Test {
	public static void main(String[] args)
	{
		int a=1;
		for(int i=1;i<=9;i++)
		{
			for(int b=1;b<=a;b++)
			{
				System.out.print(b+"*"+a+"="+a*b);
				System.out.print("	");
			}
			a++;
			System.out.println();
		}
	}
}
