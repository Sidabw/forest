
package com.diff.list;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

//import net.minidev.json.JSONArray;

public class Demo {
	public static void main(String[] args){
		List<Object> list = new ArrayList<Object>();
		list.add(new User("zhangsan",1));
		ArrayList<User> arrayList = new ArrayList<User>();
		arrayList.add(new User("lisi",0));
		arrayList.add(new User("wangwu",0));
		list.add(arrayList);
		System.out.println(JSONArray.toJSONString(list));

	}
}
class User{
	private String name;
	private Integer gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + "]";
	}
	public User(String name, Integer gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
}
