package com.gc;

public class Animal {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("��Ҫ��������");
	}
}
