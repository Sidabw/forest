package com.Java.bak.middle.Day04.src.com.zpark.pojo;

public class MyBeanFactory {
	public static User create1(){
		System.out.println("static User create1");
		return new User();
	}
	public User create2(){
		System.out.println("User create2");
		return new User();
	}
	
}
