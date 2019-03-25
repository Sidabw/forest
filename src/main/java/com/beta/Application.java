package com.beta;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Controller
@EnableAsync
@EnableSwagger2
public class Application extends SpringBootServletInitializer {
	
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

		return "Hello SpringBoot"+"------2";
	}

    @RequestMapping(value = "/methodTest", method = RequestMethod.GET)
    @ResponseBody
    public String greeting2(){
        //spring security 相关
		/*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		System.out.println("到/ 这里来了" + userDetails.getUsername());
		System.out.println(userDetails.getAuthorities());*/
        System.out.println(1);
        return "hi";
    }

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
