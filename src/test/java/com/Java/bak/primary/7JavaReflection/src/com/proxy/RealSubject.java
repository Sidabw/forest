package com.proxy;

public class RealSubject extends Subject {

	@Override
	public void request() {
		System.out.println("I'm real subject");
	}

}
