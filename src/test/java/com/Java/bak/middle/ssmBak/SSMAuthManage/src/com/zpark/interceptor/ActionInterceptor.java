package com.Java.bak.middle.ssmBak.SSMAuthManage.src.com.zpark.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zpark.annotation.AuthCheck;
 
/**
 * 全局拦截器
 */
public class ActionInterceptor implements HandlerInterceptor {
    /**
     * 前置拦截，用于检查身份与权限
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从传入的handler中检查是否有AuthCheck的声明
        HandlerMethod method = (HandlerMethod)handler;
        AuthCheck auth = method.getMethodAnnotation(AuthCheck.class);
         
        //找到了，取出定义的权限属性，结合身份信息进行检查
        if(auth != null) {
            String type = auth.type();
            boolean write = auth.write();
             
            //根据type与write，结合session/cookie等身份信息进行检查
            //如果权限检查不通过，可以输出特定信息、进行跳转等操作
            //并且一定要return false，表示被拦截的方法不用继续执行了
        }
       
        //检查通过，返回true，方法会继续执行
        return true;
    }
     
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
    }
     
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
    }
}