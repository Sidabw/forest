package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Param5 extends ActionSupport{

	private Map<String,String> m;
	public Map<String, String> getM() {
		return m;
	}
	public void setM(Map<String, String> m) {
		this.m = m;
	}
	public String execute() throws Exception{
		System.out.println(m.get("name"));
		System.out.println(m.get("pwd"));
		return super.execute();
	}
}
