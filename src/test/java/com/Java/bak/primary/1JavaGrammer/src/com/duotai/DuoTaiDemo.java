package com.duotai;

public class DuoTaiDemo {
	public static void main(String[] args)
	{
		//Animal a=new Cat();
		Function(new Cat());
		Function(new Dog());
		
		
	}
	public static void Function(Animal a)	//Animal a= new Cat();	多态
	{
		a.eat();
		if(a instanceof Cat)		//a对象是否是Cat类型的一个实例（对象）
		{
		Cat c=(Cat)a;				//强制将父类的引用转换成子类的类型
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
		System.out.println("吃鱼");
	}
	public void CatchMouse()
	{
		System.out.println("抓老鼠");
	}

}
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("吃骨头");
	}
	public void kanmen()
	{
		System.out.println("看门");
	}
}
class Pig extends Animal
{
	public void eat()
	{
	System.out.println("吃饲料");
	}
	public void gongdi()

	{
		System.out.println("拱地");
	}
}
