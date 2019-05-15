
package com.linkedlist4;
import java.util.*;
/*
 * LinkedList���з���
 * addFirst();									---->offerFirst();			
 * addLast();									   	 offerLast()
 * 
 * 
 * getFirst();									---->peekFirst();
 * getLast();
 * ֻȡ,��������û��Ԫ��ʱ�����׳�NoSuchElementException
 * 
 * removeFirst()								----->pollFirst();
 * removeLast()
 * ��ȡҲɾ
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
