
package com.linkedlist4;
import java.util.*;
/*
 * LinkedList特有方法
 * addFirst();									---->offerFirst();			
 * addLast();									   	 offerLast()
 * 
 * 
 * getFirst();									---->peekFirst();
 * getLast();
 * 只取,当集合内没有元素时，会抛出NoSuchElementException
 * 
 * removeFirst()								----->pollFirst();
 * removeLast()
 * 既取也删
 * 
 * */
public class LinkedListDemo {
	public static void main(String[] args)
	{
		LinkedList li=new LinkedList();
		li.addFirst("java01");
		li.addFirst("java02");
		li.addFirst("java03");
		li.addFirst("java04");
		sop(li);
		while(!li.isEmpty())
		{
			sop(li.removeLast());
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
