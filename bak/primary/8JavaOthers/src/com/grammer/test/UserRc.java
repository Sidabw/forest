package com.grammer.test;
public class User {
	private String uname;
	private String pwd;
	private String gender;
	public User(String uname, String pwd, String gender) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.gender = gender;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
