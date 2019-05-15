package com.Java.bak.middle.Day03.src.com.zpark.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zpark.util.MySessionFactory;

public class Demo2 {
	@Test
	public void test(){
		/**
		 * 配置lazy="true"并使用load方法来进行懒加载。减少数据库的压力。
		 * 默认lazy="true" 当lazy="false"时，不能使用load方法，只能使用get
		 * */
		Session session = MySessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Course course = session.get(Course.class, 1);
		
		tx.commit();
	}
}
