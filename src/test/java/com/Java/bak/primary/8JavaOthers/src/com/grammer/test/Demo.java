package com.grammer.test;

import java.util.LinkedList;
import java.util.Scanner;
import org.junit.Test;

/*
 * a++ 是先赋值后运算，++a是先运算后赋值
 * final修饰的变量内容引用都不可变。final修饰的对象内容可变引用不可变。
 * 
 * */
public class Demo {
	public static void main(String[] args)
	{
//		double pai=3.1415927;
//		int a=(int)pai;
//		System.out.println(a);	//3
		
		String s1="a";//s1指向字符串常量池中的"a"
		/*当使用+时，s1和"b"从字符串被复制到堆中并生成StringBuilder对象，
		 * 调用其appened方法添加元素，最后使用toString将StringBuilder转换为String*/
		 s1=s1+"b";
		String s3="a"+"b";/*编译器优化 s3指向字符串常量池*/
		System.out.println(s1=="ab");//s1在堆内存中，"ab"在字符串常量池中，所以返回false
		System.out.println(s3=="ab");//s3在字符串常量池中... 		返回true

		Float f= new Float(1.22);
		System.out.println(f.MAX_EXPONENT);
		Long l= new Long(2);
		System.out.println(l.MAX_VALUE);
		
		
		int x=4;
//		System.out.println(2*(x--));	//先赋值后运算，所以结果是8
		int y=(x--)+(--x)+(x*10);
		System.out.println(y);
	}
	@Test
	public  void te()
	{
		System.out.println("d");
		LinkedList l=new LinkedList();
		l.add("aaa");
	}
}
class Person
{
	String name;
}
