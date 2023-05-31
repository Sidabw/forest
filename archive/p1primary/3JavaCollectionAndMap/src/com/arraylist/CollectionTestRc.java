package com.arraylist;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
	public static void main(String[] args)
	{
		Collection a= new ArrayList();
		a.add("zhangsan");
		a.add(new Integer(100));
		a.add(true);
		a.add(new Person("zhangsan", 5));
		System.out.println(a);//默认调用toString（）方法
		System.out.println(a.size());
		Collection c1= new ArrayList();
		c1.add("lisi");
		c1.add(new Integer(98));
		c1.add(false);
		System.out.println(c1);
		a.addAll(c1);
		System.out.println(a);	
		System.out.println(a.size());
		a.remove(98);
		a.add(c1);
		System.out.println(a);
		System.out.println(c1);
		System.out.println(a.isEmpty());//a是否为空
		System.out.println(a.contains(c1));//a是否包含c1（也可以是元素），containsAll是a是否包含集合c1中的所有元素
		System.out.println("*****");
		System.out.println(a.retainAll(c1));//找到a和c1的交集，并赋值给a，retainAll（）方法返回值类型为boolean
		System.out.println(a);//retainAll（）之后a被改变
		System.out.println("****");
		//ArrayList转换为Object数组
		Object arr[]=a.toArray();
		for(int i=0;i<arr.length;i++)
		{
				System.out.println(arr[i]);
		}	
		System.out.println(a.size());//集合内元素个数
		a.clear();//清空集合内所有元素
		System.out.println(a);
	}
}

class Person
{
private String name;
private int age;
Person(String name,int age)
{
	this.name=name;
	this.age=age;
}
public String getName()
{
	return name;
	
}
public int getAge()
{
	return age;
}
public void setName(String name)
{
	this.name=name;
}
public void setAge(int age)
{
	this.age=age;
}
public String toString()
{
	return "[name:"+name+"],"+"[age:"+age+"]";
}
}
