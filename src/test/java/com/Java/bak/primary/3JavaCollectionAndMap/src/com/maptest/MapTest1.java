package com.maptest;
/*
 * HashMap�ص㣺����ʱ��ȡ�����ݵ�˳������ȫ����ġ�HashMap���ֻ����һ����¼�ļ�ΪNull;���������¼��ֵΪ Null����֧���߳�ͬ��
 * TreeMap��TreeMapʵ��SortMap�ӿڣ��ܹ���������ļ�¼���ݼ�����,Ĭ���ǰ���ֵ����������Ҳ����ָ������ıȽ�����
 * 				����Iterator ����TreeMapʱ���õ��ļ�¼���Ź���ġ� 
 * */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest1 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("7", "seven");
		map.put("4", "four");
		map.put("3", "two");
		map.put("1", "one");
		map.put("2", "three");
		map.put("6", "three");
		map.put("7", "three");
		map.put("3", "three");
		map.put("9", "three");
		map.put("13", "three");
		map.put("11", "three");
		System.out.println(map);
		System.out.println("=================================================================");
		Set<Map.Entry<String, String>> entry = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entry.iterator();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			System.out.println("����" + en.getKey() + ", ֵ��" + en.getValue());
		}
		
		
		System.out.println(map.containsKey("5"));
		System.out.println(map.size());
		System.out.println(map.get("7"));
		System.out.println(map.containsValue("two"));//��put��ֵ��ʱ����ļ�3��ԭ����3��Ӧ��value���ǵ��ˡ�
		
	}

}
