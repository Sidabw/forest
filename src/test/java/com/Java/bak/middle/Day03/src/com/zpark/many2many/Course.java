package com.Java.bak.middle.Day03.src.com.zpark.many2many;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private Integer id;
	private String name;
	private Set<Student> c_set=new HashSet<Student>();
	public Course() {
		super();
	}
	public Course(Integer id, String name, Set<Student> c_set) {
		super();
		this.id = id;
		this.name = name;
		this.c_set = c_set;
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
	public Set<Student> getC_set() {
		return c_set;
	}
	public void setC_set(Set<Student> c_set) {
		this.c_set = c_set;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", c_set=" + c_set + "]";
	}
}
