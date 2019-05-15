package com.Java.bak.middle.MyBatis.src.com.zpark.pojo2;

import java.util.List;

public class Course {
	private Integer id;
	private String name;
	private List<Student> stus;
	public Course() {
		super();
	}
	public Course(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
}
