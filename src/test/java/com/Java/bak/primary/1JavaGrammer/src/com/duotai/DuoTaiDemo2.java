package com.duotai;

public class DuoTaiDemo2 {
	public static void main(String[] args)
	{
		StuFunction S=new StuFunction();
		S.Function(new BaseStudent1());
		/*
		 * ��̬�г�Ա�������ص㣺1���ڱ���ʱ�ڣ��ο���������ͱ������������Ƿ��е��õķ������У�����ͨ����û�У�����ʧ�ܡ�
		 * 				 	  2: ������ʱ�ڣ��ο��������������Ƿ��е��õķ�����
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
		System.out.println("����˯");
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
		System.out.println("վ��˯");
		
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

