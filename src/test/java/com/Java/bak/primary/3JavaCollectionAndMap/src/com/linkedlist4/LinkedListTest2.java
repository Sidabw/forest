package com.linkedlist4;
/*
 * ȥ��ArrayList�е��ظ�Ԫ��
 * ע�⣺�ڵ����У�Nextһ�Σ��͵�hasNext�ж�һ��
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
		//ͨ������һ���µ�ArrayList�÷�ʽ����ԭ����al������������ӡ�ɸѡ���µ�ArrayList�У������µ�ArrayList��
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
