package com.beta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import com.beta.config.interceptor.MyInterceptor;
/*import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;*/

@Configuration
//@EnableWebMvc
//@ComponentScan("com")
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
        registry.addViewController("/beauty1").setViewName("beauty1");
        registry.addViewController("/test").setViewName("test");
        super.addViewControllers(registry);
    }

    /*@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//            resolver.setPrefix("/WEB-INF/");
//            resolver.setSuffix(".jsp");
//            resolver.setViewNames("jsps/*");
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setViewNames("jsp/*");
        resolver.setOrder(2);
        return resolver;
    }
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // templateEngine
        return templateEngine;
    }
    @Bean
    public ThymeleafViewResolver viewResolverThymeLeaf() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("utf-8");
        viewResolver.setOrder(1);
        //viewResolver.setViewNames(new String[]{"thyme/*"});
        viewResolver.setViewNames(new String[]{"thymeleaf/*","vue/*"});
        return viewResolver;
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/

    /**
    * 拦截器
    * @param registry
    */
//   @Override
//    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则,/**拦截所有请求，但是对于the request added resource handler，不拦截；
    	//								/ 拦截除了静态资源外的所有请求；
        // excludePathPatterns 用户排除拦截String... 接受String类型的可变参数
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login","/beauty1","/","/user/asynctest","/echarts");
//        registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login","/beauty1","/","/user/asynctest","/echarts");
//        super.addInterceptors(registry);
//    }

}
