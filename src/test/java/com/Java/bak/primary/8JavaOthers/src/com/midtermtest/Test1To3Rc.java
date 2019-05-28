package com.midtermtest;

public class Test1To3 {
	public static void main(String[] args) {
		System.out.println("你好");		//Test1
		/*
		 * 普通年能被4整除且不能被100整除的为闰年.（如2004年就是闰年,1901年不是闰年）
		 * 世纪年能被400整除的是闰年.(如2000年是闰年,1900年不是闰年)
		 * */
		int x=2000;
		System.out.println(x%4);
		if((x%100)==0)
		{
			if((x%400)==0)
				System.out.println(x+"年是闰年");
			else
				System.out.println(x+"年不是闰年");
		}
		else if(x%4==0)
			System.out.println(x+"年是闰年");
		else
			System.out.println(x+"年不是闰年");
		
		
		
		/*
		 * 1!+2!+3!+4!+....+10!	 =  ?
		 * 3!=1*2*3
		 * */
		int b=1;
		int c=0;
		for(int i=1;i<11;i++)
		{
			for(int a=1;a<=i;a++)
			{
				b=b*a;
			}
		c=c+b;
		b=1;
		}
		System.out.println("1!+2!+3!+4!+....+10!为"+c);
			
	}
}
