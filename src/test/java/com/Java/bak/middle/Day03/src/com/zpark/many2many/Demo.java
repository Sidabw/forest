package com.Java.bak.middle.Day03.src.com.zpark.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zpark.util.MySessionFactory;

public class Demo {
	@Test
	public void test(){
		Session session = MySessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Course course = new Course();
		Course course2 = new Course();
		
		Student student = new Student();
		Student student2 = new Student();
		
		course.setId(1);
		course.setName("Chinese");
		course2.setId(2);
		course2.setName("English");
		
		student.setId(1);
		student.setName("Sida");
		student.setGender("women");
		student2.setId(2);
		student2.setGender("man");
		student2.setName("Brew");
		
		course.getC_set().add(student);
		course.getC_set().add(student2);
		student.getSet().add(course2);
		student.getSet().add(course);
		
		session.save(course);
		session.save(course2);
		session.save(student);
		session.save(student2);
		tx.commit();
	}
}
