package com.itcast.clone;

public class Demo {
	//使用clone方法，被clone的类要implements Cloneable,and need to override method clone;
	public static void main(String[] args) throws CloneNotSupportedException {
		User user = new User("sida",1);
		User clone = user.clone();
		System.out.println(clone.getId());
	}
}
