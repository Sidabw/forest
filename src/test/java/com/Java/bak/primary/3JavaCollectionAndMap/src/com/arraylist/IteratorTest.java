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
			//�Զ�̬��ʽ�������϶���ʹ��forѭ������ʱ��ǿ������ת������Ϊget��ʽ��ArrayList�ĸ���AbstractList�ķ���
			ArrayList b=(ArrayList)a;
			System.out.println(b.get(i));	
		}
		System.out.println("****");
		
		for(Object b:a)
		{
			System.out.println(b);
		}
//�������÷�һ		
//		Iterator it=a.iterator();		
//		while(it.hasNext())
//		{
//			System.out.println(it.next());
//	
//		}
		
//�������÷���
		
		for(Iterator iterator=a.iterator();iterator.hasNext();)
		{
			Object object=iterator.next();
		//	String str=(String)object; 
			System.out.println(object);
		}
	}
}
