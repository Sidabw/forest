package com.maptest;
/*
 * HashMap特点：遍历时，取得数据的顺序是完全随机的。HashMap最多只允许一条记录的键为Null;允许多条记录的值为 Null。不支持线程同步
 * TreeMap：TreeMap实现SortMap接口，能够把它保存的记录根据键排序,默认是按键值的升序排序，也可以指定排序的比较器，
 * 				当用Iterator 遍历TreeMap时，得到的记录是排过序的。 
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
			System.out.println("键：" + en.getKey() + ", 值：" + en.getValue());
		}
		
		
		System.out.println(map.containsKey("5"));
		System.out.println(map.size());
		System.out.println(map.get("7"));
		System.out.println(map.containsValue("two"));//在put键值对时后面的键3将原来键3对应的value覆盖掉了。
		
	}

}
