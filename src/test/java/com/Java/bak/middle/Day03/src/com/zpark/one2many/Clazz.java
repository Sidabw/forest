package com.Java.bak.middle.Day03.src.com.zpark.one2many;

import java.util.HashSet;
import java.util.Set;

public class Clazz {
	private Integer id;
	private String floor;
	private String addr;
	private Set<Student> set=new HashSet<Student>();
	public Clazz() {
		super();
	}
	public Clazz(Integer id, String floor, String addr) {
		super();
		this.id = id;
		this.floor = floor;
		this.addr = addr;
	}
	public Clazz(Integer id, String floor, String addr, Set<Student> set) {
		super();
		this.id = id;
		this.floor = floor;
		this.addr = addr;
		this.set = set;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Set<Student> getSet() {
		return set;
	}
	public void setSet(Set<Student> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", floor=" + floor + ", addr=" + addr + ", set=" + set + "]";
	}
	
}
