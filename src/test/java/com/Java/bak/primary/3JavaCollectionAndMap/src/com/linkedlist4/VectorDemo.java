package com.linkedlist4;
import java.util.*;
/*
 * Vector �����ʵ�ֿ������Ķ������顣������һ��������������ʹ�������������з��ʵ���������ǣ�Vector �Ĵ�С���Ը�����Ҫ�������С��
 * ����Ӧ���� Vector �������ӻ��Ƴ���Ĳ�����
 * ���� collection ʵ�ֲ�ͬ��Vector ��ͬ���ġ� 
 * */
public class VectorDemo {
	public static void main(String[] args)
	{
		Vector v=new Vector();
		System.out.println(v.capacity());
		System.out.println();
		v.add("java0");
		v.add("java1");
		v.add("java2");
		v.add("java3");
		
		Enumeration en=v.elements();
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
		
	}

}
