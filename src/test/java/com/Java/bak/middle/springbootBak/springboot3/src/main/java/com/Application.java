package com.Java.bak.middle.springbootBak.springboot3.src.main.java.com;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.pool.DruidDataSource;


@SpringBootApplication
@Controller
public class Application {
	
	private Logger logger = Logger.getLogger(Application.class);  
	
	//url:	localhost:8080/
	@RequestMapping("/")
	@ResponseBody
	public String greeting(){
		return "Hello SpringBoot"+"------";
	}
	public static void main(String[] args){
		Application application = new Application();
		application.logger.info("项目启动");
		SpringApplication.run(Application.class, args);
	}
}
