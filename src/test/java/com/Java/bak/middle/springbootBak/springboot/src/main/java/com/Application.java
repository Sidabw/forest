package com.Java.bak.middle.springbootBak.springboot.src.main.java.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {
	
	/*@Autowired
	YmlBean ymlBean;*/
	
	//url:	localhost:8080/
	@RequestMapping("/")
	public String greeting(){
		return "Hello SpringBoot"+"------";
	}
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
