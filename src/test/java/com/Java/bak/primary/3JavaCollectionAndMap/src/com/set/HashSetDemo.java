package com.set;
/*
 * |---Set:Ԫ��������ģ�������ȡ����˳��һ��һ�£���Ԫ�ز����ظ�
 * 		|---HashSet���ײ����ݽṹ�ǹ�ϣ���̲߳�ͬ��
 * 					HashSet���ȷ������Ψһ�ԣ�
 * 					���ж�Ԫ�ص�Hashcodֵ�Ƿ���ͬ����ͬ�Ļ���false����ֱ�Ӳ���������ͬ�Ļ���true�������ж�equals��
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
			Person p=(Person)it.next();		//Object ��ǿתPerson��
			System.out.println("Name��"+p.getName()+"    Age:"+p.getAge());
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
	public int hashCode()		//��д��Object��hasCode()������
	{
		return name.hashCode()+age*22;
	}
	public boolean equals(Object obj)		//��дObject���е�equals���������û��equals��������Ȼ���������������һ���ģ�����ַ��ͬ��HashSet��ʶ����������
	{
		if(!(obj instanceof Person))	//��obj����Person���һ��ʵ��������������ʱ��ֱ�ӷ���false
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
