
package com.javatest.test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * List<Map<String,Object>> sorted by comparator
 * @author Brew	
 * @date 2018年6月21日
 */
public class Demo {
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>();
		//list.stream().collect(Collectors.su)
		List<Map<String, Object>> sumList = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("groupName", "国内新闻");
		hashMap.put("count", 13L);
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("groupName", "微博top");
		hashMap2.put("count", 12L);
		sumList.add(hashMap);
		sumList.add(hashMap2);
		Collections.sort(sumList, new Comparator<Map<String, Object>>(){

			@Override
			public int compare(Map<String, Object> m1, Map<String, Object> m2) {
				Object count1 = m1.get("count");
				Object count2 = m2.get("count");
				if((Long)count1 == (Long)count2){
					return 0;
				}else{
					return (Long)count1 > (Long)count2 ? 1 : -1;
				}
			}
			
		});
		System.out.println(sumList.get(0).get("groupName"));
		
		
		// 向 StringBuffer 中 append 1个 Object
		Object obj = new String("aaa");
		StringBuffer ss = new StringBuffer();
		ss.append(obj);
		System.out.println(ss.toString()); 
		
		Object obj1 = new Long("12");
		Object obj2 = new Long("12");
		System.out.println(obj1.equals(obj2));
		
		System.out.println("---");
		System.out.println(String.format("", "hahah"));
	}
}
