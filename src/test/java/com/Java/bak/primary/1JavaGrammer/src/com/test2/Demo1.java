package com.test2;
/*��ǿforѭ��:
 *��ǿforѭ����Ҫ�����Զ�����ʱ���Զ�������Ҫʵ��Iterable�ӿڣ�
 *����дiterator�������˷�������һ�� new Iterator ����{��дhasNext next�ȷ��� };�����ڲ���
 * */
import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;//������ʱ���.*�����������ӽӿ�Ҳȫ�����룡
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
		for(Integer b:a)//for(�������� ���������������Ŀ��ʽ)
		{
			System.out.println(b);
		}
	}

}
