package com.linkedlist4;
/*
 * ʹ��LinkedList ģ��һ����ջ���߶������ݽṹ
 * ��ջ���Ƚ�����������ڱ���
 * ���У��Ƚ��ȳ��������ڹ���
 * */
import java.util.*;
public class LinkedListTest {
	public static void main(String[] args)
	{
		Queue q=new Queue();
		q.Qadd("java01");
		q.Qadd("java01");
		q.Qadd("java02");
		q.Qadd("java03");
		q.Qadd("java04");
		while(!q.isNull())
		{
			System.out.println(q.Qget());
		}
	}

}
class Queue
{
	private LinkedList link;
	Queue()
	{
		link=new LinkedList();
	}
	public void Qadd(Object obj)
	{
		link.addFirst(obj);
	}
	public Object Qget()
	{
		return link.removeLast();
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}
	
}
