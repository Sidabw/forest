package com.Java.bak.middle.Day02.src.com.zpark.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class FilterDemo3 extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("FilterDemo3 has been invoked!");
		//incocation.invoke()执行时就放行（放行到下一个拦截器，如果没有下一个拦截器，执行action）
		//返回值：默认返回最后执行的action的 结果配置  如："success"、"add"、"find"....
		String result= invocation.invoke();
		System.out.println(result);
		//是否返回result都可
		return result;
	}

}
