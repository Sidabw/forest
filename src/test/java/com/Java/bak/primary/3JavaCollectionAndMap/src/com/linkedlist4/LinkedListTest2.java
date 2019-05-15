package com.linkedlist4;
/*
 * 去除ArrayList中的重复元素
 * 注意：在迭代中，Next一次，就得hasNext判断一次
 * */
import java.util.*;
public class LinkedListTest2 {
	public static void main(String[] args)
	{
		ArrayList al= new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");
		al.add("java02");
		System.out.println(al);
		al=singleElement(al);
		System.out.println(al);
	}
	public static ArrayList singleElement(ArrayList al)
	{
		//通过建立一个新的ArrayList得方式，将原来的al遍历并挨个添加、筛选到新的ArrayList中，返回新的ArrayList。
		ArrayList newAl=new ArrayList();
		Iterator it=al.iterator();
		while(it.hasNext())
		{
			Object obj=it.next();
			if(!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}

}
