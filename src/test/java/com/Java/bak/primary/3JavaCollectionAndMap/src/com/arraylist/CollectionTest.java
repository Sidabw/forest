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
		System.out.println(a);//Ĭ�ϵ���toString��������
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
		System.out.println(a.isEmpty());//a�Ƿ�Ϊ��
		System.out.println(a.contains(c1));//a�Ƿ����c1��Ҳ������Ԫ�أ���containsAll��a�Ƿ��������c1�е�����Ԫ��
		System.out.println("*****");
		System.out.println(a.retainAll(c1));//�ҵ�a��c1�Ľ���������ֵ��a��retainAll������������ֵ����Ϊboolean
		System.out.println(a);//retainAll����֮��a���ı�
		System.out.println("****");
		//ArrayListת��ΪObject����
		Object arr[]=a.toArray();
		for(int i=0;i<arr.length;i++)
		{
				System.out.println(arr[i]);
		}	
		System.out.println(a.size());//������Ԫ�ظ���
		a.clear();//��ռ���������Ԫ��
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
