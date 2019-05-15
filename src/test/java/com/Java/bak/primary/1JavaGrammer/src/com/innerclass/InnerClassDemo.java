package com.innerclass;

import java.util.Date;

public class InnerClassDemo {
	/*
	 * �ڲ��ࣺ
	 * 		1.static inner class (ֻ�ܷ����ⲿ��ľ�̬��Ա�;�̬����)
	 * 		2.member inner class,��Ա�ڲ��ࡣ
	 * 		3.local inner class���ֲ��ڲ���,ͬ�ֲ�����һ�����ܹ����ⲿֱ�ӷ��ʵ���ֻ���ڷ����ڷ��ʡ��ֲ��ڲ���ֻ�ܹ���������final���͵ı���
	 * 		4.anonymous inner class�������ڲ��࣬�����ʽ�ļ̳�һ�������ʵ��һ���ӿڡ�
	 * */
	public static void main(String[] args)
	{
		//��̬�ڲ���
/*		EncloingClass.InnerClass inner=new EncloingClass.InnerClass();
		inner.test();*/
		
		//��Ա�ڲ���
		MemberEncloingClass.InnerClass mec=new MemberEncloingClass().new InnerClass();
		mec.doSomething();
		
		//�ֲ��ڲ���
	/*	new LocalInnerClass().dosomething();*/
		
		//�����ڲ���
		AnonymousInnerClass aic=new AnonymousInnerClass();
		//ʵ���ϴ���getDate��������Date��������࣬������ิд��Date��toString����
		aic.getDate(new Date(){
			@Override
			public String toString() {
				return "Hello World";
			}
		});
		
		
		
	}
}

class EncloingClass
{
	private static int a=1;
	//��̬�ڲ���
	static class InnerClass
	{
		public  void test()
		{
			System.out.println(a);
		}
	}
}

class MemberEncloingClass
{
	private int a=2;
	//��Ա�ڲ���
	public class InnerClass
	{
		private int a=5;
		public void doSomething()
		{
			System.out.println(MemberEncloingClass.this.a);//���ڲ���������ⲿ�۱�������ʱ�������ⲿ��ĳ�Ա�����ķ�ʽ
			MemberEncloingClass.this.test();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void test()
	{
		InnerClass inner=this.new InnerClass();//���ⲿ��ķ����з����ڲ���
	}
}

class LocalInnerClass
{
	public void dosomething()
	{
		final int a=8;
		//�ֲ��ڲ���
		 class Inner
		{
			public void test(){
				System.out.println("Hello World");
				System.out.println("��ֻ�ܷ��ʷ�����fianl���͵ı���"+a);
			}
		}
		new Inner().test();
	}
}

//�����ڲ���
class AnonymousInnerClass
{
	public void getDate(Date date){
		System.out.println(date.toString());	
	}
}

