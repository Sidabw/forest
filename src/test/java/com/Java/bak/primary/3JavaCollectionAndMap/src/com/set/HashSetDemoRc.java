package com.set;
/*
 * |---Set:元素是无序的（存入与取出的顺序不一定一致），元素不可重复
 * 		|---HashSet：底层数据结构是哈希表，线程不同步
 * 					HashSet如何确定数据唯一性？
 * 					先判断元素的Hashcod值是否相同，不同的话（false），直接惭怍。，相同的话（true），在判断equals。
 * */
import java.util.*;
public class HashSetDemo {
	public static void main(String[] args)
	{
		HashSet hs=new HashSet();
		hs.add(new Person("a1",11));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",13));
		hs.add(new Person("a1",11));
		Iterator it=hs.iterator();
		while(it.hasNext())
		{
			Person p=(Person)it.next();		//Object 类强转Person类
			System.out.println("Name："+p.getName()+"    Age:"+p.getAge());
		}
	}
}
class Person
{
	private String name;
	private int age;
	public Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int hashCode()		//复写了Object的hasCode()方法，
	{
		return name.hashCode()+age*22;
	}
	public boolean equals(Object obj)		//复写Object类中的equals方法，如果没有equals方法，虽然两个对象的属性是一样的，但地址不同，HashSet认识是两个对象
	{
		if(!(obj instanceof Person))	//当obj不是Person类的一个实例或者是其子类时，直接返回false
			return false;
		
		Person p=(Person)obj;
		return this.name.equals(p.name)&&this.age==p.age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}
