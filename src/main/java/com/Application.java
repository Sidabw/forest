package com;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Controller
@EnableAsync
@EnableSwagger2
public class Application extends SpringBootServletInitializer{
	
	private Logger logger = Logger.getLogger(Application.class);  
	
	//url:	localhost:8081/
	@RequestMapping("/")
	@ResponseBody
	public String greeting(){
		//spring security 相关
		/*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		System.out.println("到/ 这里来了" + userDetails.getUsername());
		System.out.println(userDetails.getAuthorities());*/

		return "Hello SpringBoot"+"------";
	}
	public static void main(String[] args){
		Application application = new Application();
		application.logger.info("项目启动");
		SpringApplication.run(Application.class, args);
	}
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
