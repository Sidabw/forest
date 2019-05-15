package com.Java.bak.middle.Day04.src.com.zpark.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	@Test
	public void test(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	/*1.在scope="prototype"的时候 ，多例，返回false
	 * User u = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		System.out.println(u==u2);*/
		
	//	ac.close();
		
/*		User user = (User) ac.getBean("user2");
		System.out.println(user);*/
		
		User user=(User) ac.getBean("user3");
		System.out.println(user);
		
	}
}
