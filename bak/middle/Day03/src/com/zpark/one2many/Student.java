package com.Java.bak.middle.Day03.src.com.zpark.one2many;

public class Student {
	private Integer id;
	private String name;
	private String gender;
	private Clazz clazz;
	public Student(Integer id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	public Student(Integer id, String name, String gender, Clazz clazz) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.clazz = clazz;
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
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", clazz=" + clazz + "]";
	}
	
}
