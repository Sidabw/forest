package com.innerclass;

import java.util.Date;

public class InnerClassDemo {
	/*
	 * 内部类：
	 * 		1.static inner class (只能访问外部类的静态成员和静态方法)
	 * 		2.member inner class,成员内部类。
	 * 		3.local inner class，局部内部类,同局部变量一样不能够从外部直接访问到，只能在方法内访问。局部内部类只能够访问类外final类型的变量
	 * 		4.anonymous inner class，匿名内部类，其会隐式的继承一个父类或实现一个接口。
	 * */
	public static void main(String[] args)
	{
		//静态内部类
/*		EncloingClass.InnerClass inner=new EncloingClass.InnerClass();
		inner.test();*/
		
		//成员内部类
		MemberEncloingClass.InnerClass mec=new MemberEncloingClass().new InnerClass();
		mec.doSomething();
		
		//局部内部类
	/*	new LocalInnerClass().dosomething();*/
		
		//匿名内部类
		AnonymousInnerClass aic=new AnonymousInnerClass();
		//实质上传给getDate方法的是Date对象的子类，这个子类复写了Date的toString方法
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
	//静态内部类
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
	//成员内部类
	public class InnerClass
	{
		private int a=5;
		public void doSomething()
		{
			System.out.println(MemberEncloingClass.this.a);//当内部类变量与外部累变量重名时：访问外部类的成员变量的方式
			MemberEncloingClass.this.test();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void test()
	{
		InnerClass inner=this.new InnerClass();//在外部类的方法中访问内部类
	}
}

class LocalInnerClass
{
	public void dosomething()
	{
		final int a=8;
		//局部内部类
		 class Inner
		{
			public void test(){
				System.out.println("Hello World");
				System.out.println("我只能访问方法中fianl类型的变量"+a);
			}
		}
		new Inner().test();
	}
}

//匿名内部类
class AnonymousInnerClass
{
	public void getDate(Date date){
		System.out.println(date.toString());	
	}
}

