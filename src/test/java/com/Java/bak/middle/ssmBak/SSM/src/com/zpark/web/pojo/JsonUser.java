package com.Java.bak.middle.ssmBak.SSM.src.com.zpark.web.pojo;

import java.util.List;

public class JsonUser {
	private Integer id;
	private String name;
	private String tel;
	private List<Integer> list;
	public JsonUser() {
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
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "JsonUser [id=" + id + ", name=" + name + ", tel=" + tel + "]";
	}
	
}
