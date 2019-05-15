package com.Java.bak.middle.Day03.src.com.zpark.many2many;
import java.util.HashSet;
import java.util.Set;
public class Student {
	private Integer id;
	private String name;
	private String gender;
	private Set<Course> set=new HashSet<Course>();
	public Student(Integer id, String name, String gender, Set<Course> set) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.set = set;
	}
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
	public Set<Course> getSet() {
		return set;
	}
	public void setSet(Set<Course> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", set=" + set + "]";
	}
	
}
