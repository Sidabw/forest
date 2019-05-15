package com.set;
import java.util.*;
/*
 * comparator�����ⲿ�Ƚ�����comparable�����ڲ��Ƚ������ڲ��޸�Դ�����ǰ���£�ʹ��comparator��Ϊ���ʡ�
 * comparator���ȼ�����comparable------->�ⲿ�Ƚ������ȼ������ڲ��Ƚ���
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
class MyCompare implements Comparator			//�Զ���Ƚ�����ʵ��comparator ����compare����
{
	public int compare(Object o1,Object o2)
	{
		Student1 s1=(Student1)o1;
		Student1 s2=(Student1)o2;
		
		int num=s1.getName().compareTo(s2.getName());		//����String��compareTo������lang����
		if(num==0)
		{
			num=new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));		//����Iteger��CompareTo������lang�������ֶ�װ��
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
			throw new RuntimeException("����ѧ������");
		Student1 s=(Student1)obj;
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
			{
				return this.name.compareTo(s.name);		//����String��compareTo��������ʵ����Comparable�ӿ�
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
