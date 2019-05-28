package com.maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapHomework {
	public static void main(String[] args) {
		String[] str={"abc","456","abc","wer","456"};	
		HashMap<String, Integer> hmap=new HashMap<String,Integer>();
//		Set<Map.Entry<String,Integer>> entry=hmap.entrySet();
//		Iterator<Map.Entry<String, Integer>> it=entry.iterator();
//		Map.Entry<String, Integer> en=it.next();
		int i=0;
		int value=1;
//		Set<String> s=hmap.keySet();
		for(;i<str.length;i++)
		{
			String key=str[i];
			Set<String> s2=hmap.keySet();//hmsp.keySet()	返回此映射中所包含的键的 Set 视图
			if(!s2.contains(str[i]))			
			{
				hmap.put(key, value);
//				System.out.println(1);
			}
				else
				hmap.put(key, 2);//hmap.put(key,valuse)	在此映射中关联指定值与指定键。如果该映射以前包含了一个《该键》的映射关系，则旧值被替换。
		//Set<String> s2=hmap.keySet();
		}
		Set<String> s1=hmap.keySet();
		Iterator<String> it=s1.iterator();
		while(it.hasNext())
		{
			String keyi=it.next();
			System.out.println(keyi+hmap.get(keyi));
		}
	}
}
