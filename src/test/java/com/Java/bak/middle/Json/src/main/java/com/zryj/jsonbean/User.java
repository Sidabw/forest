package com.Java.bak.middle.Json.src.main.java.com.zryj.jsonbean;

public class User
{
	private String name;
	private int date;
	private String gender;
	//������д�ղι��췽�����������JSONObject��toBean�������User����ʱ�ᱨ�?
	public User()
	{
		super();
	}
	public User(String name, int date, String gender)
	{
		super();
		this.name = name;
		this.date = date;
		this.gender = gender;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getDate()
	{
		return date;
	}
	public void setDate(int date)
	{
		this.date = date;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
}
