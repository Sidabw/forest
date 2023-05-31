package com.Java.bak.middle.Day04.src.com.zpark.jdbctemplate;

import java.beans.PropertyVetoException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo {
	/**
	 * 手动测试jdbc模板
	 * */
	@Test
	public void test() throws Exception{
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql:///514high");
		comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		comboPooledDataSource.setMinPoolSize(3);
		comboPooledDataSource.setMaxPoolSize(6);
		
	}
}
