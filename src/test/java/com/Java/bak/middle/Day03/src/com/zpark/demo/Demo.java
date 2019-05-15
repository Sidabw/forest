package com.Java.bak.middle.Day03.src.com.zpark.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.zpark.bean.User;

public class Demo {
	@Test
	public void test(){
		Configuration conf = new Configuration();
		//加载默认配置文件： hibernate.cfg.xml
		conf.configure();
		//创建sessionFactory，占内存大，建议一个web项目只使用1个sessionFactory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//创建新的session，每次都会创建一个新的。
		Session session = sessionFactory.openSession();
		//获取当前线程的session
		//Session currentSession = sessionFactory.getCurrentSession();
		//事务对象，控制提交和回滚
		Transaction ts = session.getTransaction();
		ts.begin();
		/*
		 * 方式二：
		Transaction beginTransaction = session.beginTransaction();
		 * */
		/*添加数据
		 * session.save(new User(null,"Sida","0622"));*/
		/*修改数据，sql 语句 where 后是 id=?
		 * User u=new User(2,"Brew","1106");
		session.update(u);*/
		/*删除数据
		session.delete(user);*/
		//查看数据
//		User user = session.get(User.class,2);
//		System.out.println(user);
//		user.setTel(null);
//		session.update(user);
//		user.setName("sss");
		try {
			User user = new User(2,"Sida","1106");
			session.update(user);
			System.out.println("dd");
			session.update(new User(2,null,"111"));
			System.out.println("aaa");
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		}
		session.close();
		sessionFactory.close();
	}
}
