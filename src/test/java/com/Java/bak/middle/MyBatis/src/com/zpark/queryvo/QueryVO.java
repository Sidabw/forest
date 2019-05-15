package com.Java.bak.middle.MyBatis.src.com.zpark.queryvo;

import java.util.List;

public class QueryVO {
	private List<Integer> ids;
	private String name;
	private String tel;
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
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
	
}
