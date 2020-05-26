package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class InterceptorSession extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("Interceptor.....................................................");
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println(session);
		if(session==null||session.get("user")==null){
			return "tologin";
		}
		String invoke = invocation.invoke();
		return invoke;
	}

}
