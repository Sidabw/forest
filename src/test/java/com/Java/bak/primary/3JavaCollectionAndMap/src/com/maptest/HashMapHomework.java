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
			Set<String> s2=hmap.keySet();//hmsp.keySet()	���ش�ӳ�����������ļ��� Set ��ͼ
			if(!s2.contains(str[i]))			
			{
				hmap.put(key, value);
//				System.out.println(1);
			}
				else
				hmap.put(key, 2);//hmap.put(key,valuse)	�ڴ�ӳ���й���ָ��ֵ��ָ�����������ӳ����ǰ������һ�����ü�����ӳ���ϵ�����ֵ���滻��
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
