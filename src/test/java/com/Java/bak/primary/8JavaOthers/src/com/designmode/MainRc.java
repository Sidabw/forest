package com.designmode;

public class Main {
	public static void main(String[] args) {
		User build = new User.Builder().age(1).isMarried(false).name("brew").build();
		System.out.println(build.getName());
	}
}
