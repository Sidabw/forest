package com.midtermtest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Question11ToEnd {
	public static void main(String[] args) {
		
	}

}

/*
 *Question11:
 *		如何把用逗号分隔的字符串变成数组？
 *		public static void main(String[] args) {
		String aString="zha,n,g,san";
		String[] bString=aString.split(",");
		for(int i=0;i<bString.length;i++)
		{
			System.out.print(bString[i]);
		}
*Question12:
*		Collection实现比较要实现什么接口？
*		集合中添加的对象上实现comparable接口，并复写compareTo方法、
*		或者自定义比较器实现comparator，并覆写compare方法，在创建集合的时候将自定义比较器传到参数列表中
*
*Question13:
*		List是有序的可重复。
*		Set是无序的不可重复。TreeSet是有序的，二叉树排序。
*		Map:键值对，键不可重复，值可重复。如果第二次put相同的键，不同的值，那么该键对应的值被改变
*			TreeSet是有序的，二叉树排序。
*
*Question14:
*		List和Set是Collection的子接口，
*
*Question15:
*		List、Set、Map存取元素时有什么特点？
*		List中ArrayList存取元素是通过角标来，LinkedList存取元素是通过每个角链的尾标地址来挨个查找，但增删较快
*		Set中TreeSet是通过二叉树来存取元素，所以是有序且不可重复的，HashSet是通过HashCode和Hash表来增删查找元素
*		Map中存取的是键值对。
*Question16:
*		Conllection和Conllections的区别？
*		Conllections是一个包装类，此类不能被实例化，是一个服务于Collection的工具类，包含
*		各种有关集合操作的静态多态方法。使用其中的sort方法时，Collection中的所有元素必须实现comparab接口。
*		public static void main(String[] args) {
		List list =new ArrayList();
		int arr[]={8,3,2,5,6};
		for(int i=0;i<arr.length;i++)
		{
			list.add(arr[i]);
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}	
	}
Question17:
		List、Set、Map各自的方法
		List：
			ArrayList: add  get isEmpty  indexof(返回列表中首次出现次元素的索引，没有则返回-1)   remove  set(int dext,E elment)	size()  toArray
			LinkedList: 没有isEmpty
		Set:
			HashSet:
			TreeSet:
		Map:
			HashMap:
			TreeMap:
	
Question18:

		hashCode方法常规协议规定相同的对象必须具有相同的hashCode
		
	         在集合里，如果子类和父类都复写了compareTo方法那么各自调用自己的compareTo方法
      	如果子类没有复写compareTo方法，那么调用的都是父类的compareTo方法 
		
Question19:
		常见的类、包、接口
		类：Object	Integer		Math	Array	ArrayList
		包：java.util	java.lang	
		接口：List 	Set		Map		Iterator	Comparable		

 * 
 */
 