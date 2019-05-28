package com.duotai;

public class DuoTaiDemo2 {
	public static void main(String[] args)
	{
		StuFunction S=new StuFunction();
		S.Function(new BaseStudent1());
		/*
		 * 多态中成员函数的特点：1：在编译时期，参考左边引用型变量所属的类是否有调用的方法。有，编译通过；没有，编译失败。
		 * 				 	  2: 在运行时期，参考对象所属的类是否含有调用的方法。
		 * */
		Fu f=new Zi();
		f.method1();		
		
	}	
}
abstract class Student1
{
	public abstract void study();
	public void sleep()
	{
		System.out.println("sleep");
	}
	
}
class StuFunction
{
	public void Function(Student1 stu)
	{

		stu.sleep();
		stu.study();

	}
}
class BaseStudent1 extends Student1
{
	public void study()
	{
		System.out.println("BaseStudy");
	}
	public void sleep()
	{
		System.out.println("躺着睡");
	}
}
class AdvStudent extends Student1
{
	public void study()
	{
		System.out.println("AdvStudy");
	}
	public void sleep()
	{
		System.out.println("站着睡");
		
	}
}
class Fu

{
	void method1()
	{
		System.out.println("f_method1");
	}
	void method2()
	{
		System.out.println("f_method2");
	}
}
class Zi extends Fu
{
	void method1()
	{
		System.out.println("z_method1");
	}
	void method3()
	{
		System.out.println("z_method3");
	}
	void method4()
	{
		System.out.println("z_method4");
	}
	void method5()
	{
		System.out.println("z_method5");
	}
}

