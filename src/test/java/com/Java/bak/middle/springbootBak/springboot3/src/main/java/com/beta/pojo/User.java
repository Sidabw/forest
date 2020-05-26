package com.Java.bak.middle.springbootBak.springboot3.src.main.java.com.beta.pojo;

public class User {
	private String name;
	private String gender;
	private String hobby;
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", hobby=" + hobby
				+ "]";
	}
	public User(String name, String gender, String hobby) {
		super();
		this.name = name;
		this.gender = gender;
		this.hobby = hobby;
	}
	public User() {
		super();
	}
}
