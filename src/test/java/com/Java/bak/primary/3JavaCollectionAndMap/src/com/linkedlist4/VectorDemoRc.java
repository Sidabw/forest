package com.linkedlist4;
import java.util.*;
/*
 * Vector 类可以实现可增长的对象数组。与数组一样，它包含可以使用整数索引进行访问的组件。但是，Vector 的大小可以根据需要增大或缩小，
 * 以适应创建 Vector 后进行添加或移除项的操作。
 * 与新 collection 实现不同，Vector 是同步的。 
 * */
public class VectorDemo {
	public static void main(String[] args)
	{
		Vector v=new Vector();
		System.out.println(v.capacity());
		System.out.println();
		v.add("java0");
		v.add("java1");
		v.add("java2");
		v.add("java3");
		
		Enumeration en=v.elements();
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
		
	}

}
