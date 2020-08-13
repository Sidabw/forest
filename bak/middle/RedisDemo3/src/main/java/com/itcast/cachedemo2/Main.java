package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.cachedemo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.cachedemo.Account;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-cache-anno.xml");// 加载 spring 配置文件
		AccountService s = (AccountService) context
				.getBean("accountServiceBean");
		// 第一次查询，应该走数据库
		System.out.print("first query...");
		s.getAccountByName("somebody");
		// 第二次查询，应该不查数据库，直接返回缓存的值
		System.out.print("second query...");
		s.getAccountByName("somebody");
		System.out.println();
		
		System.out.println("start testing clear cache...");    // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
	    Account account1 = s.getAccountByName("somebody1"); 
	    // 开始更新其中一个    account1.setId(1212);
	    s.updateAccount(account1); 
	    s.getAccountByName("somebody1");// 因为被更新了，所以会查询数据库    s.getAccountByName("somebody2");
	    System.out.println("----------------------");
	    s.getAccountByName("somebody1");//走缓存，没有打印
	    s.getAccountByName("somebody2");
	    s.getAccountByName("somebody2");
	    System.out.println("-------------");//有somebody1和somebody2两个缓存
	    s.reload(); 
	    s.getAccountByName("somebody1");
	    s.getAccountByName("somebody2");
	    System.out.println("-------------");//reload方法清空了名为accountCache的所有缓存
	    
	    
	}
}
