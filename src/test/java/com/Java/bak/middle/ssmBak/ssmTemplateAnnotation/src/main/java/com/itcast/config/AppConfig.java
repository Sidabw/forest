package com.Java.bak.middle.ssmBak.ssmTemplateAnnotation.src.main.java.com.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.itcast")
@EnableTransactionManagement
@MapperScan("com.itcast.mybatis")
public class AppConfig {
	
	@Autowired
	private Environment env;

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(env.getProperty("spring.datasource.user"));
        druidDataSource.setPassword(env.getProperty("spring.datasource.password"));
        druidDataSource.setUrl(env.getProperty("spring.datasource.url"));
        druidDataSource.setDriverClassName(env.getProperty("spring.datasource.driver"));
        return druidDataSource;
    }
}