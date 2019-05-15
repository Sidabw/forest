package com.Java.bak.middle.ssmBak.ssmTemplateAnnotationDemo.src.main.java.com.itcast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//表明当前类是一个配置类
@ComponentScan(basePackages = "com.itcast")//配置要扫描的包
//@MapperScan("com.itcast.mybatis")
public class SpringConfiguration {
	
}

