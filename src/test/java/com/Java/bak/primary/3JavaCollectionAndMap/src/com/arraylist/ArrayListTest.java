package com.arraylist;

import java.util.List;
import java.util.ArrayList;
/**
 * ArrayList�Ĳ������;subList ��ͷ����β
 * */
public class ArrayListTest {
	public static void main(String[] args)
	{
		List list =new ArrayList();
		list.add("zhangsan");
		list.add(new Integer(100));
		list.add("hello");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println("======================================");
		list.add(0, "wangwu");
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+"  ");
		}
		
		
		List list1= new ArrayList();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("ccc");
		list1.add("ddd");
		list1.add("eee");
		System.out.println("==========================================");
		List list2=list1.subList(1, 4);	//  ��ͷ����β
		for(int i=0;i<list2.size();i++)
		{
			System.out.println(list2.get(i));
		}

	}

}
