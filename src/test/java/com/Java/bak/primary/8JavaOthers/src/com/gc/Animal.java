package com.gc;

public class Animal {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("我要被回收了");
	}
}
