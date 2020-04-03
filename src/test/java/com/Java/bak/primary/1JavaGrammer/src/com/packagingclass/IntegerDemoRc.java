package com.packagingclass;
/*
 * 基本数据类型对象包装类
 * byte Byte
 * short Short
 * int	Integer
 * long	Long
 * boolean	Boolean
 * float Float
 * double	Double
 * char	Character
 * 
 * 基本数据类型转字符串
 * 34+""
 * Integer.toString(34)
 * */



//parse    --------->从语法上描述或分析

public class IntegerDemo {
	public static void main(String[] args)
	{
//		int a=34;
//		String temp=Integer.toString(a);	
		//整数行嘞的最大值
		System.out.println("int MAX="+Integer.MAX_VALUE);
		//将一个字符转换成整数
		int num=Integer.parseInt("123");//将字符串参数作为有符号的十进制数值进行解析
		long x=Long.parseLong("213235");
		boolean b=Boolean.parseBoolean("true");
		System.out.println("num="+(num+4));
		System.out.println("x="+(x+1));		
		System.out.println(b);
		System.out.println(Integer.toBinaryString(6));		//十进制------->二进制
		System.out.println(Integer.toHexString(60));		//十进制------->十六进制
		//将指定数字转换成指定进制
		int a=Integer.parseInt("110",2);	//2进制 Binaray-------> 		十进制
		int c=Integer.parseInt("3c",16);	//十六进制 Hex    ------>		十进制
		System.out.println("Binary"+a+"       "+c);
	}

}
