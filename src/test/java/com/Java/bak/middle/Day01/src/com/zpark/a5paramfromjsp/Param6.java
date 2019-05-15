package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Param6 extends ActionSupport{
	private List<User> list ;
	public String execute() throws Exception{
		System.out.println(list.get(0).getName());
		System.out.println(list.get(0).getTel());
		return super.execute();
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
}
