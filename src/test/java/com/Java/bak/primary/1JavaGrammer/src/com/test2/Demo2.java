package com.test2;
/*
 * �ɱ������
 * 		��������... ������
 * �ɱ����ʵ������һ������
 * һ���������ֻ����һ���ɱ����
 * */

public class Demo2 {
	public static void main(String[] args) {
		add("haha",1,2,3);
	}
	public static void add(String b,int...a)//�ɱ��������λ���βε����һ��must be the last parameter������һ������ֻ����һ���ɱ����
	{
		int result=0;
		for(int item:a)
		{
			result+=item;		//result=result+item
		}
		System.out.println(result);
		System.out.println(a);	//�ɱ����ʵ������һ������
		System.out.println(a.length);
	}
}
