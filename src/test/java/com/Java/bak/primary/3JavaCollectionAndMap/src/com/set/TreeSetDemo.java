package com.set;
import java.util.*;
/*
 *  |---TreeSet:���Զ�Set���ϵ�Ԫ�ؽ�����Ȼ���򡣣�ASCII���
 *  		�ײ������Ƕ���������֤����Ψһ�Ե����ݣ�compareTo����return 0����ȣ���-1 С�ڣ�1 ����
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
	public int compareTo(Object obj)//��дCompareble��compare���������ڵ���С�ڷֱ𷵻�1 0 -1��������0ʱ�������غϣ�TreeSet��ֻ��һ����
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("����ѧ������");
		Student s=(Student)obj;
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

