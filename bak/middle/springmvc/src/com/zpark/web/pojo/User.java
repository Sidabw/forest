package com.Java.bak.middle.springmvc.src.com.zpark.web.pojo;

public class User {
	private Integer id;
	private String name;
	private String tel;
	public User() {
		super();
	}
	public User(Integer id, String name, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", tel=" + tel + "]";
	}
	
}
