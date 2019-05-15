package com.itcast.order;

public class HelloA {
	public HelloA(){
		System.out.println("HelloA Constructor");
	}
	{System.out.println("HelloA code");}
	static {
		System.out.println("HelloA static code");
	}
	public static void main(String[] args) {
		new HelloB();
	}
}
class HelloB extends HelloA{
	public HelloB(){
		System.out.println("HelloB Constructor");
	}
	{System.out.println("HelloB code");}
	static {
		System.out.println("HelloB static code");
	}
	
}
