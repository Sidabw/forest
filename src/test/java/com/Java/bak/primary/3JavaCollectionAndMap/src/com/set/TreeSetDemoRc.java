package com.set;
import java.util.*;
/*
 *  |---TreeSet:可以对Set集合的元素进行自然排序。（ASCII码表）
 *  		底层数据是二叉树。保证数据唯一性的依据：compareTo方法return 0（相等），-1 小于，1 大于
 * */
public class TreeSetDemo {
	public static void main(String[] args)
	{
		TreeSet ts=new TreeSet();
		ts.add(new Student("a1",11));
		ts.add(new Student("a2",12));
		ts.add(new Student("a3",13));
		ts.add(new Student("a1",11));
		
		Iterator it=ts.iterator();
		while(it.hasNext())
		{
			Student s=(Student)it.next();
			System.out.println(s.getAge()+s.getName());
		}
	}
}
class Student implements Comparable
{
	private String name;
	private int age;
	public Student(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Object obj)//复写Compareble的compare方法，大于等于小于分别返回1 0 -1，当等于0时，对象重合，TreeSet里只放一个。
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("不是学生对象");
		Student s=(Student)obj;
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
			{
				return this.name.compareTo(s.name);		//调用String的compareTo方法，其实现了Comparable接口
			}
			return -1;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
}

