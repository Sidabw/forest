package com.Java.bak.middle.MyBatis.src.com.zpark.pojo2;

import java.util.List;

public class Student {
	private Integer id;
	private String name;
	private String gender;
	private List<Course> cours;
	public Student() {
		super();
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
	public List<Course> getCours() {
		return cours;
	}
	public void setCours(List<Course> cours) {
		this.cours = cours;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", cours=" + cours + "]";
	}
}
