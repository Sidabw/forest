package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
public class Param8 extends ActionSupport{
	private Map<String,User> m;
	public String execute(){
		System.out.println(m.get("name").getName());
		System.out.println(m.get("tel").getTel());
		return SUCCESS;
	}
	public Map<String, User> getM() {
		return m;
	}
	public void setM(Map<String, User> m) {
		this.m = m;
	}
}
