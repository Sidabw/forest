package com.Java.bak.middle.Day03.src.com.zpark.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.zpark.bean.User;
import com.zpark.util.MySessionFactory;

public class Demo2 {
	@Test
	public void test(){
		Session session = MySessionFactory.getSession();
		session.beginTransaction();
		//查询所有信息
/*		String hql="from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user.getName());
		}*/
		//条件查询
/*		String hql="from User where id=?";
		Query query = session.createQuery(hql);
		//与JDBC不同，第一个占位符在JDBC里是1，hibernate里是0
		query.setParameter(0, 1);
		User user = (User)query.uniqueResult();
		System.out.println(user.getName());*/
		//使用自定义别名条件查询
/*		String hql="from User where id=:Naid";
		Query query = session.createQuery(hql);
		query.setParameter("Naid", 1);
		Object uniqueResult = query.uniqueResult();
		System.out.println(uniqueResult);*/
		//分页查询
/*		String hql="from User";
		Query query = session.createQuery(hql);
		//从第0条记录开始查  一共查两条
		query.setFirstResult(0);
		query.setMaxResults(2);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user.getName());
		}*/
	}
	@Test
	public void test2(){
		Session session = MySessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		//查询所有信息
/*		Criteria createCriteria = session.createCriteria(User.class);
		List list = createCriteria.list();
		for (Object object : list) {
			System.out.println(object);
		}*/
		//使用Criteria规则条件查询
/*		Criteria createCriteria = session.createCriteria(User.class);
		createCriteria.add(Restrictions.eq("id",1));
		User user = (User)createCriteria.uniqueResult();
		System.out.println(user);*/
		//分页查询
/*		Criteria criteria = session.createCriteria(User.class);
		//从第0条数据开始，查两条
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List list = criteria.list();
		for (Object object : list) {
			System.out.println(object);
		}*/
		//使用聚合函数
/*		Criteria criteria = session.createCriteria(User.class);
		criteria.setProjection(Projections.rowCount());
		Object uniqueResult = criteria.uniqueResult();
		System.out.println(uniqueResult);*/
		
		tx.commit();
	}
	/**
	 * 使用原生SQL
	 * */
	@Test
	public void test3(){
		Session session = MySessionFactory.getSession();
		session.beginTransaction();
		//查询RowCount
/*		String sql="select count(*) from user";
		SQLQuery query = session.createSQLQuery(sql);
		Object uniqueResult = query.uniqueResult();
		System.out.println(uniqueResult);*/
		//查询所有记录
/*		String sql="select * from user";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		List<User> list = query.list();
		for (User u : list) {
			System.out.println(u);
		}*/
		//条件查询
/*		String sql="select * from user where id=? and name=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, 1);
		query.setParameter(1, "123");
		Object uniqueResult = query.uniqueResult();
		System.out.println(uniqueResult);*/
		//分页查询
/*		String sql="select * from user limit ?,?";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		//第0个占位符 数据库中的第二条数据
		query.setParameter(0, 1);
		query.setParameter(1, 2);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user.getName());
		}*/
		
		
	}
}
