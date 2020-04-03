package com.generic;
import java.util.*;
/*
 * Generic(泛型)：JDK1.5新特性，用于解决安全问题，是一个安全机制。
 * 之前运行时的ClassCastException转移到了编译时期，方便程序员解决问题。
 * */
public class GenericDemo {
	public static void main(String[] args)
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		Iterator<String> it=al.iterator();
		while(it.hasNext())
		{
			String s=it.next();			//不用强转
			System.out.println(s+"....."+s.length());
		}
	}
}
