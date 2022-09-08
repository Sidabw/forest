package com.test2;

import java.util.ArrayList;

/*
 * 自动装箱：
 * 自动拆箱：把一个包装类对象直接赋给对应的基本数据类型
 * */
public class Demo3 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(5);//自动装箱
		int i=arrayList.get(0);//自动拆箱int i=(Integer)arrayList.get(0);
		System.out.println(i);
	}
}
