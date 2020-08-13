package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import com.opensymphony.xwork2.ActionSupport;

public class Param1 extends ActionSupport{
	private String name;
	public String execute() throws Exception{
		System.out.println(name);
		return super.execute();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
