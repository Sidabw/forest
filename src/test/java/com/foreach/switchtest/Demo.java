
package com.foreach.switchtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
	public static final String a = "a";
		 public static void main(String[] args){
		List<Object> list = new ArrayList<>();
		list.add("abc");
		list.add(1);
		list.add(2);
		list.add(3);
		list = list.stream().map(e -> {
			if(e instanceof Integer){
				e = 1;
			}
			return e;
		}).collect(Collectors.toList());
		list.stream().forEach(e -> System.out.println(e));
	}
	public static void ss(){
		System.out.println(11);
	}
}
