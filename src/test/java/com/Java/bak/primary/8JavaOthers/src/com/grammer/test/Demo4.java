package com.grammer.test;

public class Demo4 {
	public static void main(String[] args) {
		char a='a';
		int i=a;
		System.out.println(i);	//97
		byte b=127;//���ɽ�128��ֵ��b���뱨��
		float f=1.22222f;
		System.out.println(i+f);	//����Ǵ�С����
		Person2 p =new Person2();
	}
}
//ִ��˳�򣺸��ྲ̬��Ա�����ྲ̬����飬���ྲ̬��Ա�����ྲ̬����飬����ʵ����Ա���������飬���๹�췽��������ʵ����Ա���������飬���๹�췽��
class Person2{
	private String str;
	{
		System.out.println("���ǹ�������");
	}
	static{
		System.out.println("��̬�����");
	}
	public Person2(){
		this("zhangsna");
		System.out.println("���췽��");
	}
	public Person2(String str)
	{
		super();
		this.str=str;
	}
}
