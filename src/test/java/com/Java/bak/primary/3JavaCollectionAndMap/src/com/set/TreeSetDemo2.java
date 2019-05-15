package com.set;
import java.util.*;
/*
 * comparator属于外部比较器，comparable属于内部比较器。在不修改源代码的前提下，使用comparator更为合适。
 * comparator优先级高于comparable------->外部比较器优先级高于内部比较器
 * */
public class TreeSetDemo2 {
	public static void main(String[] args)
	{
			TreeSet ts = new TreeSet(new MyCompare());
			ts.add(new Student1("lisi02",10));
			ts.add(new Student1("lisi02",12));
			ts.add(new Student1("lisi02",10));
			ts.add(new Student1("lisi12",10));
			ts.add(new Student1("lisi022",90));
			
			Iterator it=ts.iterator();
			while(it.hasNext())
			{
				Student1 stu=(Student1)it.next();
				System.out.println(stu.getName()+"......."+stu.getAge());
			}

	}

}
class MyCompare implements Comparator			//自定义比较器，实现comparator 覆盖compare方法
{
	public int compare(Object o1,Object o2)
	{
		Student1 s1=(Student1)o1;
		Student1 s2=(Student1)o2;
		
		int num=s1.getName().compareTo(s2.getName());		//调用String类compareTo方法（lang包）
		if(num==0)
		{
			num=new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));		//调用Iteger类CompareTo方法（lang包），手动装箱
		}
		return num;
	}
}
class Student1 implements Comparable
{
	private String name;
	private int age;
	public Student1(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Object obj)
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("不是学生对象");
		Student1 s=(Student1)obj;
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
