package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Param7 extends ActionSupport{
	public Map<String,String> m;
	public String execute(){
		System.out.println(m.get("name"));
		System.out.println(m.get("pwd"));
		return SUCCESS;
	}
	public Map<String, String> getM() {
		return m;
	}
	public void setM(Map<String, String> m) {
		this.m = m;
	}
}
