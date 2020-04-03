package com.Java.bak.middle.Json.src.main.java.com.beta.jsonbean;

import java.util.ArrayList;

public class User {
	private Integer id;
	private String name;
	private String tel;
	private ArrayList<Integer> list;
	public User(Integer id, String name, String tel, ArrayList<Integer> list) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.list = list;
	}
	public User() {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
}
