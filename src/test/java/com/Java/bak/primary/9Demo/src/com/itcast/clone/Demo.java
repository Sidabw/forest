package com.itcast.clone;

public class Demo {
	//ʹ��clone��������clone����Ҫimplements Cloneable,and need to override method clone;
	public static void main(String[] args) throws CloneNotSupportedException {
		User user = new User("sida",1);
		User clone = user.clone();
		System.out.println(clone.getId());
	}
}
