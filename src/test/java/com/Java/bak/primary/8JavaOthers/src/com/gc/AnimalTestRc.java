package com.gc;

public class AnimalTest {
	public static void main(String[] args) {
		new Animal();
		new Animal();
		new Animal();
		new Animal();
		new Animal();
		System.gc();
//		Runtime.getRuntime().gc();
		
	}
}
