package com.itcast.aboutextends;

public class User extends Father{
	public void test(){
		super.test();
		System.out.println("User test");
		this.testt();
	}
	public void testt(){
		System.out.println("User testt");
	}
}
