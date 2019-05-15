package com.itcast.threaddemo;

public class Demo {
	public static void main(String[] args) {
		/*Foo foo = new Foo();
		Thread thread = new Thread(foo);
		thread.run();
		System.out.println("Demo");
*/		
		String str = "5";
		System.out.println(str+2);
		}
}
class Foo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Foo");
	}
	
}
