package com.proxy;

public class ProxySubject extends Subject {
	private RealSubject realSubject=null;
	public void request() {
		preRequest();
		
		if(realSubject==null)
		{
			realSubject=new RealSubject();
		}
		
		realSubject.request();
		postRequest();
		
	}
	public void preRequest()
	{
		System.out.println("invoked before the real request method");
	}
	public void postRequest()
	{
		System.out.println("invoked after the real request method");
	}

}
