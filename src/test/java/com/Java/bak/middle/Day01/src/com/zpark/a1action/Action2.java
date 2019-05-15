package com.Java.bak.middle.Day01.src.com.zpark.a1action;

import com.opensymphony.xwork2.Action;

public class Action2 implements Action{

	public String execute() throws Exception {
		System.out.println("Im Action2 execute!");
		return SUCCESS;
	}

}
