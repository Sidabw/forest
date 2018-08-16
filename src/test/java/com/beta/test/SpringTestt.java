package com.beta.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beta.mybatis.mapper.TbUser;
import com.beta.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
// @ComponentScan("com.beta")
// @ContextConfiguration(classes={DBConfig.class,MyWebMvcConfigurerAdapter.class},
// initializers = ConfigFileApplicationContextInitializer.class)
public class SpringTestt {

	public static final int i = 1;
	@Autowired
	private IUserService userService;

	@Test
	public void testt() {
		List<TbUser> queryList = userService.queryList();
		System.out.println(queryList.get(0).getUsername());
	}
	public static void main(String[] args) {
		//i++;
	}
}
