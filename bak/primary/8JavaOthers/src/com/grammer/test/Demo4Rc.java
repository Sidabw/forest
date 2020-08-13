package com.grammer.test;

public class Demo4 {
	public static void main(String[] args) {
		char a='a';
		int i=a;
		System.out.println(i);	//97
		byte b=127;//不可将128赋值给b编译报错
		float f=1.22222f;
		System.out.println(i+f);	//结果是带小数点
		Person2 p =new Person2();
	}
}
//执行顺序：父类静态成员，父类静态代码块，子类静态成员，子类静态代码块，父类实例成员，父类代码块，父类构造方法，子类实例成员，子类代码块，子类构造方法
class Person2{
	private String str;
	{
		System.out.println("我是构造代码块");
	}
	static{
		System.out.println("静态代码块");
	}
	public Person2(){
		this("zhangsna");
		System.out.println("构造方法");
	}
	public Person2(String str)
	{
		super();
		this.str=str;
	}
}
