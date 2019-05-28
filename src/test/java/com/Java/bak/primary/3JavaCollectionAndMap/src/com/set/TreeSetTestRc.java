package com.set;
import java.util.*;
/*
 *要求：按照字符长度排序
 * */

public class TreeSetTest {
	public static void main(String[] args)
	{
		TreeSet<String> ts=new TreeSet<String>(new StrLenComparator());
		ts.add("aadaa");
		ts.add("aa");
		ts.add("ada");
		ts.add("jaadaa");
		ts.add("acdaa");
		ts.add("aaca");
//		ts.add(new Person1("chougoushi"));
//		ts.add(new Person1("luolei"));
//		ts.add(new Person1("shaoguangze"));
//		ts.add(new Person1("guangfeng"));
		
		Iterator<String> it=ts.iterator();
		while(it.hasNext())
		{
//			Person1 p=(Person1)it.next();
			System.out.println(it.next());
		}
	}
}
class StrLenComparator implements Comparator<String>	//比较器泛型
{
	public int compare(String s1,String s2)
	{
//		String s1=(String)o1;
//		String s2=(String)o2;
		int num=new Integer(s1.length()).compareTo(s2.length());
		if(num==0)
			num=s1.compareTo(s2);	//调用字符串的compareTo方法  按照字符串顺序比较两个字符串
		return num;
	}
}
class Person1 implements Comparable
{
	private String name;
	Person1(String name)
	{
		this.name=name;
	}
	public int compareTo(Object o)
	{
		Person1 p=(Person1)o;
		if(p.getName().length()<name.length())
			return 1;
		if(p.getName().length()>name.length())
			return -1;
//		if(p.getName().length()==name.length())
			return 0;
	}
	public String getName()
	{
		return name;
	}
}
