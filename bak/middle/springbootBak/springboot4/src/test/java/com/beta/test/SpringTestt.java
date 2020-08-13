package com.Java.bak.middle.springbootBak.springboot4.src.test.java.com.beta.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beta.config.DBConfig;
import com.beta.config.MyWebMvcConfigurerAdapter;
import com.beta.mapper.TbUser;
import com.beta.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@ComponentScan("com.beta")
//@ContextConfiguration(classes={DBConfig.class,MyWebMvcConfigurerAdapter.class}, initializers = ConfigFileApplicationContextInitializer.class)
public class SpringTestt {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testt(){
		List<TbUser> queryList = userService.queryList();
		System.out.println(queryList.get(0).getUsername());
	}
}
