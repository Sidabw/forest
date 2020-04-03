package com.Java.bak.middle.Day03.src.com.zpark.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
	public static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	public static Session getSession(){
		//return sessionFactory.openSession();
		return sessionFactory.getCurrentSession();
	}
}
