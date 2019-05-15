package com.test2;
/*
 * 可变参数：
 * 		数据类型... 变量名
 * 可变参数实际上是一个数组
 * 一个方法最多只能有一个可变参数
 * */

public class Demo2 {
	public static void main(String[] args) {
		add("haha",1,2,3);
	}
	public static void add(String b,int...a)//可变参数必须位于形参的最后一个must be the last parameter，所以一个方法只能有一个可变参数
	{
		int result=0;
		for(int item:a)
		{
			result+=item;		//result=result+item
		}
		System.out.println(result);
		System.out.println(a);	//可变参数实际上是一个数组
		System.out.println(a.length);
	}
}
