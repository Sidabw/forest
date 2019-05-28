package com.money;

import java.math.BigDecimal;

/**
 * BigDecimal基本操作
 * */
public class Demo2 {
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("1.1");
		BigDecimal b = new BigDecimal("10.0");
		System.out.println("a+b="+a.add(b));
		System.out.println("a-b="+a.subtract(b));
		System.out.println("a*b="+a.multiply(b));
		System.out.println("a/b="+a.divide(b));
	}
}
