package com.grammer.test;

import java.util.LinkedList;
import java.util.Scanner;
import org.junit.Test;

/*
 * a++ ���ȸ�ֵ�����㣬++a���������ֵ
 * final���εı����������ö����ɱ䡣final���εĶ������ݿɱ����ò��ɱ䡣
 * 
 * */
public class Demo {
	public static void main(String[] args)
	{
//		double pai=3.1415927;
//		int a=(int)pai;
//		System.out.println(a);	//3
		
		String s1="a";//s1ָ���ַ����������е�"a"
		/*��ʹ��+ʱ��s1��"b"���ַ��������Ƶ����в�����StringBuilder����
		 * ������appened�������Ԫ�أ����ʹ��toString��StringBuilderת��ΪString*/
		 s1=s1+"b";
		String s3="a"+"b";/*�������Ż� s3ָ���ַ���������*/
		System.out.println(s1=="ab");//s1�ڶ��ڴ��У�"ab"���ַ����������У����Է���false
		System.out.println(s3=="ab");//s3���ַ�����������... 		����true

		Float f= new Float(1.22);
		System.out.println(f.MAX_EXPONENT);
		Long l= new Long(2);
		System.out.println(l.MAX_VALUE);
		
		
		int x=4;
//		System.out.println(2*(x--));	//�ȸ�ֵ�����㣬���Խ����8
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
