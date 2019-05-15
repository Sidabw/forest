package com.Java.bak.middle.Day03.src.com.zpark.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zpark.util.MySessionFactory;

public class Demo {
	@Test
	public void test(){
		Session session = MySessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student(1,"Sida","women");
		Student student2 = new Student(2,"Brew","man");
		
		Clazz clazz = new Clazz(1,"5","BeiJing514");
		
		clazz.getSet().add(student);
		clazz.getSet().add(student2);
		
		student.setClazz(clazz);
		student2.setClazz(clazz);
		
		//持久态
		session.save(clazz);
		session.save(student);
		session.save(student2);
		
		tx.commit();
	}
	@Test
	public void test2(){
		Session session = MySessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, 1);
		session.delete(student);
		tx.commit();
	}
	/**
	 * 级联删除
	 * */
	@Test
	public void test3(){
		Session session = MySessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Clazz clazz = session.get(Clazz.class, 2);
		session.delete(clazz);
		tx.commit();
	}
	
}
