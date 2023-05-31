package com.Java.bak.middle.Day04.src.com.zpark.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zpark.pojo.User;
/**
 * 
@Component("annotation")
@Controller("annotation")	//web层
@Service("annotation")		//service层
@Repository("annotation")	//dao层
 * */

public class Annotation1 {

	@Value("萝卜头")
	private String value;
	@Test
	public void test(){
		ClassPathXmlApplicationContext ts = new ClassPathXmlApplicationContext("com/zpark/annotation/applicationContext.xml");
		User u = (User) ts.getBean("u1");
		System.out.println(u);
	}
	//配置初始化方法，对象创建完成调用
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	//配置对象销毁前调用
	@PreDestroy
	public void destory(){
		
	}
}
