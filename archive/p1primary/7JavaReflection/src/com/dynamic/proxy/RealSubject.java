package com.dynamic.proxy;

public class RealSubject implements Subject {

	@Override
	public void request(String str) {
		// TODO Auto-generated method stub
		System.out.println("I'm the real Subject"+ "   "+ str);
	}

}
