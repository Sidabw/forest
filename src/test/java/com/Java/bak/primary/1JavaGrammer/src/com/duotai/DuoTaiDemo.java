package com.duotai;

public class DuoTaiDemo {
	public static void main(String[] args)
	{
		//Animal a=new Cat();
		Function(new Cat());
		Function(new Dog());
		
		
	}
	public static void Function(Animal a)	//Animal a= new Cat();	��̬
	{
		a.eat();
		if(a instanceof Cat)		//a�����Ƿ���Cat���͵�һ��ʵ��������
		{
		Cat c=(Cat)a;				//ǿ�ƽ����������ת�������������
		c.CatchMouse();			
		}
		if(a instanceof Dog)
		{
			Dog d=(Dog)a;
			d.kanmen();
		}
	}

}
abstract class Animal
{
	abstract void eat();
}
class Cat extends Animal
{
	public void eat()
	{
		System.out.println("����");
	}
	public void CatchMouse()
	{
		System.out.println("ץ����");
	}

}
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("�Թ�ͷ");
	}
	public void kanmen()
	{
		System.out.println("����");
	}
}
class Pig extends Animal
{
	public void eat()
	{
	System.out.println("������");
	}
	public void gongdi()

	{
		System.out.println("����");
	}
}
