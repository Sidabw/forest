package com.Java.bak.middle.DWR2.src.com.zpark.pojo;

import java.util.List;

public class Clazz {
	private Integer id;
	private String floor;
	private String addr;
	
	private List<Student> stu;
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}
	public Clazz() {
		super();
	}
	public Clazz(Integer id, String floor, String addr) {
		super();
		this.id = id;
		this.floor = floor;
		this.addr = addr;
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
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", floor=" + floor + ", addr=" + addr + ", stu=" + stu + "]";
	}
	
}
