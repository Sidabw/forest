package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Param4 extends ActionSupport {
	private List<String> list;

	public String execute() throws Exception{
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		return super.execute();
	}
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}
