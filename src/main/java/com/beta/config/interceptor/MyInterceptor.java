package com.beta.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterHandle");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		/*if(resp.getStatus() == 500 || resp.getStatus() == 404){
			modelAndView.setViewName("errorPage");
		}*/
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		/*System.out.println("preHandle");
		boolean flag =true;
        LoginUser user=(LoginUser)request.getSession().getAttribute("user");
        if(null==user){
            response.sendRedirect("/toLogin");
            flag = false;
        }else{
            flag = true;
        }*/
        return true;
	}

}
