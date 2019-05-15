package com.arraylist3;
/*
 * List:元素是有序的，可以重复。因为该集合有索引

 * 		|---ArrayList:	底层的数据结构使用的是数组结构。特点：查询速度快，但是增删稍慢		线程不同步
 * 		|---LinkList:	底层使用的是链表数据结构     	特点：查询速度慢，增删速度快
 * 						在查询的时候，虽然同样可以调用LinkedList的get(index)方法，但是依然是从第0 index开始查询，直到找到index对应的元素
 * 		|---Vector:		底层是数组数据结构 		线程同步
 * Set:元素是无序的， 元素不可重复
 * 
 * List特有方法：可以操作角标
 * 增
 * 删
 * 改
 * 查
 * List集合特有的迭代器，ListIterator是Iterator的子接口
 * 在迭代时，不可以使用集合对象的方法操作集合的元素
 * 会发生异常ConcurrentModificationException
 * 
 * */
import java.util.*;

public class CollectionList {
	public static void main(String[] args)
	{
		//列表迭代器  ListIterator
		ArrayList al=new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		System.out.println(al);
		ListIterator li=al.listIterator();		
		while(li.hasNext())		// 正向遍历
		{
			Object obj=li.next();
			
			System.out.println(obj);
			if(obj.equals("java02"))
				//li.add("java09");
				li.set("java06");// ListIterator中的 set（E e)方法，用指定元素替换 next 或 previous 返回的最后一个元素
		}		
		System.out.println(al);
		while(li.hasPrevious())		//经过正向遍历之后游标处于最后一个元素的后面，所以调用ListIterator里的hasPrevious会返回ture
		{
			System.out.println(li.previous());
		}
		System.out.println("----------------------------------------------------");
		method();
	}
	public static void method()
	{
		ArrayList al=new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		//在指定位置添加元素
		al.add(1,"java09");                                                           
		System.out.println(al);
		//删除指定位置的元素
		al.remove(2);
		System.out.println(al);
		//修改元素
		al.set(2, "javaLL");
		System.out.println(al);
		//通过角标获取元素
		System.out.println(al.get(1));
		//获取所有元素-------->遍历
		for(int x=0;x<al.size();x++)	
		{
			System.out.println("al("+x+")="+al.get(x));
		}
		
		for(Iterator it=al.iterator();it.hasNext();)
		{
			System.out.println(it.next());
		}
		//通过indexOf获取对象的位置
		System.out.println(al.indexOf("javaLL"));
		//获取子列表
		List sub=al.subList(1, 2);		//包头不包尾
		System.out.println(sub);
	}

}
