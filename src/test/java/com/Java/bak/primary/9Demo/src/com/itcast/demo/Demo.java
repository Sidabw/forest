package com.itcast.demo;

public class Demo {
	/*public static void main(String[] args){
		User user = new User("zhangsan", 11);
		int i=100;
		*//**
		 * user���ݵ��Ǵ����õ�user�����á�
		 * ����i�Ǿֲ�����������ı䡣
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
//		a=100;	//����final���ε����Բ������޸�
		final User user = new User("sida", 1);
		user.setId(0);//������
//		user=new User("brew", 1);	//����final�޸ĵ����Բ������޸ġ������������͵�ַ���ɱ䡣
		
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
