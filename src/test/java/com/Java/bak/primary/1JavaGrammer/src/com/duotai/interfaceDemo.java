package com.duotai;

public class interfaceDemo {
	public static void main(String[] args)
	{
		//Drinking D= new Drinking();
		//Smoke S=new Smoke();
		BaseStudent B= new BaseStudent();		//�����������ʱ���Զ����ø��಻�������Ĺ��췽����
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

	 public void smoke();		//�ӿ��е����з������ǳ��󷽷�������abstract���Բ�д

}

class BaseStudent extends Student implements Smoke
{

	void drinking()
	{System.out.println("drinking");}
	void Study(){}
	public void smoke(){}

}
