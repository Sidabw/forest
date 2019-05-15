package com.Java.bak.middle.Day04.src.com.zpark.springtest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zpark.pojo.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/zpark/injection/applicationContext.xml")
public class Demo {
/**
 * spring单元测试不需要再手动的去创建容器，通过RunWith 和 ContextConfiguration 注解完成容器的配置
 * 
 * 开发过程中的springJUnit主要是在service层
 * */
	@Resource(name="us3")
	private User u;
	@Test
	public void test(){
		System.out.println(u);
	}
}
