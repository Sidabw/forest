package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		StringBuffer url = request.getRequestURL();
		Object user = request.getSession().getAttribute("user");
		/**
		 * �ڲ��ǵ�½�����������ж�session�����Ƿ����û�
		 * */
		if(url.toString().endsWith("login.do")){
			return true;
		}
		else if(user==null){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<script type='text/javascript'>alert('�����µ�½');top.location.href='/g2c3/login.jsp';</script>");
		}
		else{
			return true;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
