package com.Java.bak.middle.MyBatis.src.com.zpark.pojo;

public class Student {
	private Integer id;
	private String name;
	private String gender;
	private Clazz c;
	public Student() {
		super();
	}
	public Student(Integer id, String name, String gender, Clazz c) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.c = c;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Clazz getC() {
		return c;
	}
	public void setC(Clazz c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", c=" + c + "]";
	} 
	
}
