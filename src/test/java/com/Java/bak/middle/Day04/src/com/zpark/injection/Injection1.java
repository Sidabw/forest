package com.Java.bak.middle.Day04.src.com.zpark.injection;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zpark.pojo.User;

public class Injection1 {

	@Test
	public void test(){
		ClassPathXmlApplicationContext tc=new ClassPathXmlApplicationContext("com/zpark/injection/applicationContext.xml");
/*		User u = (User) tc.getBean("us");
		System.out.println(u);*/
/*		User u = (User) tc.getBean("us2");
		System.out.println(u);*/
/*		User u=(User) tc.getBean("us3");
		System.out.println(u);*/
/*		User u=(User) tc.getBean("us4");
		System.out.println(u);*/
		//在spring容器属性为singleton时，改变对象的值，就直接改变了spring容器内对象的值
		User u=(User) tc.getBean("us5");
		u.setId(1);
		System.out.println(u);
		tc.close();
//		User u2=(User) tc.getBean("us5");
//		System.out.println(u2);
		
	}
}
