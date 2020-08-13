package com.duotai;

public class interfaceDemo {
	public static void main(String[] args)
	{
		//Drinking D= new Drinking();
		//Smoke S=new Smoke();
		BaseStudent B= new BaseStudent();		//创建子类对象时会自动调用父类不带参数的构造方法。
		B.drinking();		
	}

}
abstract class Student
{
	Student()
	{
		System.out.println("0000");
	}
	void Sleep()
	{
		System.out.println("sleep");
	}
	abstract void Study();
	
}
 
interface Smoke 
{

	 public void smoke();		//接口中的所有方法都是抽象方法，所以abstract可以不写

}

class BaseStudent extends Student implements Smoke
{

	void drinking()
	{System.out.println("drinking");}
	void Study(){}
	public void smoke(){}

}
