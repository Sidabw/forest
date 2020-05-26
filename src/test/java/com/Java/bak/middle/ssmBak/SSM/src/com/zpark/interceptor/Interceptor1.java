package com.Java.bak.middle.ssmBak.SSM.src.com.zpark.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	/**
	 * preHanle: 请求到达后台之前执行
	 * postHandle:后台执行完之后执行此方法
	 * afterHandler:所有请求完成之后执行
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle1");
		//做判断，为false的情况直接重定向。 然后返回false
		//response.sendRedirect("/SSM/jsp/hello.jsp");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle1");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterHandle1");
	}

}
