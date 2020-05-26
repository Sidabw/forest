package com.Java.bak.middle.Day02.src.com.zpark.filter;

import com.opensymphony.xwork2.ActionSupport;

public class FilterTestDemo extends ActionSupport{
	public String add(){
		System.out.println("Add Method was invoked!");
		return "add";
	}
	public String del(){
		System.out.println("Del Method was invoked!");
		return "del";
	}
	public String update(){
		System.out.println("Update Method was invoked!");
		return "update";
	}
	public String find(){
		System.out.println("Find Method was invoked!");
		return "find";
	}
}
