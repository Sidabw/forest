package com.beta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.beta.interceptor.MyInterceptor;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
	/**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//配置资源映射路径+真实路径
    	registry.addResourceHandler("/my/**").addResourceLocations("classpath:/mystaticdir/");
        super.addResourceHandlers(registry);
    }
    /**
     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/toHello").setViewName("hello");
        registry.addViewController("/toupload").setViewName("uploadBase64");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/echarts").setViewName("echarts");
        registry.addViewController("/echarts2").setViewName("echarts2");
        registry.addViewController("/echarts3").setViewName("echarts3");
        registry.addViewController("/echarts4").setViewName("echarts4");
        registry.addViewController("/a").setViewName("a");
        registry.addViewController("/beauty1").setViewName("beauty1");
        super.addViewControllers(registry);
    }
    /**
    * 拦截器
    * @param registry
    */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则,/**拦截所有请求，但是对于the request added resource handler，不拦截；
    	//								/ 拦截除了静态资源外的所有请求；
        // excludePathPatterns 用户排除拦截String... 接受String类型的可变参数
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/").excludePathPatterns("/toLogin","/login","/user/loginTest","/","/user/asynctest","/echarts");
        super.addInterceptors(registry);
    }*/
}
