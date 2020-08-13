package com.Java.bak.middle.MyBatis.src.com.zpark.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory sessionFactory;
	/**
	 * 在静态代码块中初始化SqlSessionFactory，只执行1次
	 * */
	static{
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-cfg.xml");
			SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
			sessionFactory= factoryBuilder.build(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取SqlSession
	 * */
	public static SqlSession getSession(){
		SqlSession session = sessionFactory.openSession();
		return session;
	}
}
