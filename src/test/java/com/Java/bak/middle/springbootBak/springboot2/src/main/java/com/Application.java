package com.Java.bak.middle.springbootBak.springboot2.src.main.java.com;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beta.ControllerMy;


@SpringBootApplication
@RestController
public class Application {
	
	private Logger logger = Logger.getLogger(Application.class);  
	
	/*@Autowired
	YmlBean ymlBean;*/
	
	//url:	localhost:8080/
	@RequestMapping("/")
	public String greeting(){
		return "Hello SpringBoot"+"------";
	}
	public static void main(String[] args){
		Application application = new Application();
		application.logger.info("项目启动");
		SpringApplication.run(Application.class, args);
	}
}
