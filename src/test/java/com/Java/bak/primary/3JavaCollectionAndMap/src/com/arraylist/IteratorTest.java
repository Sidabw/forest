package com.arraylist;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class IteratorTest {
	public static void main(String[] args)
	{
		Collection a=new ArrayList();
		a.add("one");
		a.add("one");
		a.add("three");
		
		for(int i=0;i<a.size();i++)
		{
			//以多态形式创建集合对象，使用for循环遍历时需强制类型转换。因为get方式是ArrayList的父类AbstractList的方法
			ArrayList b=(ArrayList)a;
			System.out.println(b.get(i));	
		}
		System.out.println("****");
		
		for(Object b:a)
		{
			System.out.println(b);
		}
//迭代器用法一		
//		Iterator it=a.iterator();		
//		while(it.hasNext())
//		{
//			System.out.println(it.next());
//	
//		}
		
//迭代器用法二
		
		for(Iterator iterator=a.iterator();iterator.hasNext();)
		{
			Object object=iterator.next();
		//	String str=(String)object; 
			System.out.println(object);
		}
	}
}
