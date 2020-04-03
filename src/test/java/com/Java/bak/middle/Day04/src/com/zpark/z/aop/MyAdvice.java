package com.Java.bak.middle.Day04.src.com.zpark.z.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void before(){
		System.out.println("前置通知");
	}
	public void afterReturning(){
		System.out.println("后置通知，出现异常的时候不调用");
	}
	public Object around(ProceedingJoinPoint pj) throws Throwable{
		System.out.println("环绕通知前");
		Object proceed = pj.proceed();
		System.out.println("环绕通知后");
		return proceed;
	}
	public void afterThrowing(){
		System.out.println("出现异常了。");
	}
	public void after(){
		System.out.println("后置通知，出现异常的时候也会调用");
	}
	
}
