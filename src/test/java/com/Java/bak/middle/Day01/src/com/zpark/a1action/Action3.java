package com.Java.bak.middle.Day01.src.com.zpark.a1action;

import com.opensymphony.xwork2.ActionSupport;

public class Action3 extends ActionSupport {
	@Override
	public String execute() throws Exception {
		System.out.println("Im Action3 execute!");
		return super.execute();
	}
}
