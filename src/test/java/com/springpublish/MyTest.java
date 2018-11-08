package com.springpublish;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:com/beta/demo/applicationContext.xml");
        MyPublisher myPubisher=(MyPublisher) context.getBean("myPublisher");
        myPubisher.publishEvent(new MyEvent("1"));
	}
}
