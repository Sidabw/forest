package com.generic;

import java.util.*;
/*
 * ? 通配符，占位符。
 * ? extends E,可以接收E类型及其子类，上限。
 * ? super E,可以接收E类型及其父类，下线。
 * */
public class GenericDemo5 {
	public static void main(String[] args)
	{
		ArrayList<Person> a=new ArrayList<Person>();
		a.add(new Person("abc1"));
		a.add(new Person("abc2"));
		a.add(new Person("abc3"));	
		
		
		ArrayList<Student1> b=new ArrayList<Student1>();
		a.add(new Student1("abc----1"));
		a.add(new Student1("abc----2"));
		a.add(new Student1("abc----3"));
		print(a);
		print(b);
		
		ArrayList<Student2> c=new ArrayList<Student2>();
	}
	public static void print(ArrayList<? extends Person> a)		//泛型限定，可以接受Person类型及其子类型(子类不光指本类)
	{
		Iterator<? extends Person> it=a.iterator();				//泛型限定，迭代器
		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}
	}
		/*
		ArrayList<String> a=new ArrayList<String>();
		a.add("abc1");
		a.add("abc2");
		a.add("abc3");
		
		ArrayList<Integer> i=new ArrayList<Integer>();
		i.add(2);
		i.add(5);
		i.add(3);
		
		print(a);
		print(i);
	}
	public static void print(ArrayList<?> a)
	{
		Iterator<?> it=a.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
*/
}
class Person
{
	private Integer i;
	private String name;
	Person(String name)
	{
		this.name=name;
	}
	Person(Integer i)
	{
		this.i=i;
	}
	public String getName()
	{
		return name;
	}
	public Integer getInteger()
	{
		return i;
	}
	
}
class Student1 extends Person
{
	Student1(String name)
	{
		super(name);
	}
}
class Student2 extends Person
{
	Student2(Integer i)
	{
		super(i);
	}
}
