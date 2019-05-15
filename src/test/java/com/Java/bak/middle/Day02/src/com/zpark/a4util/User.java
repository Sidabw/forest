package com.Java.bak.middle.Day02.src.com.zpark.a4util;

public class User
{
	private String uname;
	private String realname;
	private String pwd;
	private String tel;
	private int id;
	private String power;
	public String getPower()
	{
		return power;
	}
	public void setPower(String power)
	{
		this.power = power;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public User(String uname, String realname, String pwd, String tel)
	{
		super();
		this.uname = uname;
		this.realname = realname;
		this.pwd = pwd;
		this.tel = tel;
	}
	public User()
	{
		super();
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setRealname(String realname)
	{
		this.realname = realname;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	
}
