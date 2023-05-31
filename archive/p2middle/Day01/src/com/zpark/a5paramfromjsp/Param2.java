package com.Java.bak.middle.Day01.src.com.zpark.a5paramfromjsp;

import com.opensymphony.xwork2.ActionSupport;

public class Param2 extends ActionSupport{
	private User user=new User();
	public String execute() throws Exception{
		System.out.println(user.getName());
		System.out.println(user.getTel());
		return super.execute();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
