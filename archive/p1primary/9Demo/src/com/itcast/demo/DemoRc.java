package com.itcast.demo;

public class Demo {
	/*public static void main(String[] args){
		User user = new User("zhangsan", 11);
		int i=100;
		*//**
		 * user传递的是创建好的user的引用。
		 * 但是i是局部变量，不会改变。
		 * *//*
		test(user, i);
		System.out.println(user.getId()+"-------"+i);
	}
	public static void test(User user ,int i){
		i=0;
		user.setId(1);
	}*/
	/*public static void main(String[] args){
//		final int a=0;
//		a=100;	//报错，final修饰的属性不可以修改
		final User user = new User("sida", 1);
		user.setId(0);//不报错
//		user=new User("brew", 1);	//报错，final修改的属性不可以修改。引用数据类型地址不可变。
		
	}*/
	public static void main(String[] args){
		User user = new User("sida", 1);
		Demo.test(user);
		System.out.println(user.getName());
	}
	public static void test(User user){
		user=new User("brew", 2);
	}
}
