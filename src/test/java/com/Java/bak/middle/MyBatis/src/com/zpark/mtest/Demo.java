package com.Java.bak.middle.MyBatis.src.com.zpark.mtest;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zpark.pojo.User;

public class Demo {

	@Test
	public void test() throws Exception{
		//1.读取核心配置文件
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-cfg.xml");
		//2.创建sessionFactory
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = factoryBuilder.build(resourceAsStream);
		//3.获取session
		SqlSession session = sessionFactory.openSession();
		//4.执行sql
		User u = (User)session.selectOne("find",1);
		System.out.println(u.getName());
		//session.insert("add", new User(null,"sidaaaaa","9876543"));
		//session.delete("del");
		//session.delete("del2",new User(16,null,null));
		//session.update("upd",new User(13,"lllllbt","233333"));
		//session.commit();
		//System.out.println(u);
	}
}
