package com.test2;
/*增强for循环:
 *增强for循环想要遍历自定义类时，自定义类需要实现Iterable接口，
 *并重写iterator方法，此方法返回一个 new Iterator （）{重写hasNext next等方法 };匿名内部类
 * */
import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;//导包的时候带.*代表其子类子接口也全部导入！
import java.util.Set;

import org.junit.Test;

public class Demo1 {
	public static void main(String[] args) {
//		String[] a={"abc","def","ghi"};
//		HashSet<Integer> hSet=new HashSet<Integer>();
//		hSet.add(5);
//		hSet.add(4);
//		hSet.add(6);
//		System.out.println(hSet);
//		sFor(hSet);
		HashMap<String, Integer> hMap= new HashMap<String,Integer>();
		hMap.put("zhangsan",3);
		hMap.put("wangwu", 2);
		hMap.put("lisi", 4);
		Set<Map.Entry<String,Integer>> s=hMap.entrySet();
		for(Map.Entry<String, Integer> a:s)
		{
			System.out.println(a.getKey()+","+a.getValue());
		}
	}
	
	public static void sFor(HashSet<Integer> a)
	{
		for(Integer b:a)//for(变量类型 变量名：需遍历的目标式)
		{
			System.out.println(b);
		}
	}

}
