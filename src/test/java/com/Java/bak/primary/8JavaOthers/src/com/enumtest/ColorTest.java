package com.enumtest;
/*
 * enumͬclass interfaceһ������java�Ĺؼ��֣����е�values������jvm�ڱ���java��ʱ����ӵľ�̬������������Enum����з���
 * 
 * ʹ��enum����ö������ʱ���������������ʵ�����Ǽ̳���java.lang.Enum,ÿ��ö�����͵ĳ�Ա����һ��ʵ����instance����public static final
 * 
 * ��ö�ٷ��õ������б�������������ȷ���ƽ��ܵĲ����� 
 * */
public class ColorTest {
	public static void main(String[] args) {
		Color myColor=Color.BLACK;
		System.out.println(myColor);
		System.out.println("******************");
		
		for(Color c:Color.values())
		{
			System.out.println(c);
		}
	}
}
