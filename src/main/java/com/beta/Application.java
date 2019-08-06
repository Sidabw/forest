package com.beta;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;


@SpringBootApplication
@Controller
@EnableAsync
@EnableSwagger2
public class Application extends SpringBootServletInitializer {
	
	private Logger logger = Logger.getLogger(Application.class);

    @Autowired
    private ApplicationContext applicationContext;
	
	//url:	localhost:8081/
	@RequestMapping("/")
	@ResponseBody
	public String greeting(){
//        registMapping();
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
	private void registMapping(){
	    try {
            RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
            Method getMappingForMethod =ReflectionUtils.findMethod(RequestMappingHandlerMapping.class, "getMappingForMethod",Method.class,Class.class);
            getMappingForMethod.setAccessible(true);

//            String javaPath = "/Users/feiyi/Desktop/Demo2.java";
//            String classPath = "Users.feiyi.Desktop.Demo2.class";
//            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
//            systemJavaCompiler.run(null, null, null , javaPath);
            MyClassloader myClassloader = new MyClassloader();
            Class<?> demo2Class = myClassloader.findClass("Demo2");
            Object demo2Obj = demo2Class.newInstance();
            Method dyReqTest = demo2Class.getMethod("dyReqTest");
            RequestMappingInfo mapping_info = (RequestMappingInfo) getMappingForMethod.invoke(requestMappingHandlerMapping, dyReqTest,demo2Class);
            requestMappingHandlerMapping.registerMapping(mapping_info, demo2Obj, dyReqTest);
            System.out.println(1);
        } catch (Exception e) {
	        e.printStackTrace();
        }
        System.out.println(0);
    }

//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("/Users/feiyi/Desktop/tmptest2");
//        System.out.println(2);
//        return factory.createMultipartConfig();
//    }
}
