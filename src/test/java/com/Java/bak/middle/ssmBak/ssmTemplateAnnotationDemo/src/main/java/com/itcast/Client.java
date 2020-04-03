package com.Java.bak.middle.ssmBak.ssmTemplateAnnotationDemo.src.main.java.com.itcast;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itcast.service.UserServiceImpl;

public class Client {
	public static void main(String[] args) {
		//1.获取容器：由于我们已经没有了xml文件，所以再用读取xml方式就不能用了。
		//这时需要指定加载哪个类上的注解
		ApplicationContext ac = 
			new AnnotationConfigApplicationContext(SpringConfiguration.class);
		//2.根据id获取对象
		UserServiceImpl us = (UserServiceImpl) ac.getBean("userService");
		us.getUserById(7);
	}
}
