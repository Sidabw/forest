package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.cachedemo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.cachedemo.Account;
import com.itcast.cachedemo2.AccountService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-cache-anno-self-defined.xml");// 加载 spring 配置文件

		AccountService s = (AccountService) context
				.getBean("accountServiceBean");

		Account account = s.getAccountByName("someone");
		System.out.println("passwd=" + account.getPassword());//在没走缓存之前，pwdnull
		account = s.getAccountByName("someone");
		//因为在mycache中对pwd进行了固定设置，所以从缓存中取pwd会是特定值
		System.out.println("passwd=" + account.getPassword());
	}

}
