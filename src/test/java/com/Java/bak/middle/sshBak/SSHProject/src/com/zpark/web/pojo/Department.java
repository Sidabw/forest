package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.web.pojo;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer department_id;
	private String department_name;
	private String department_desc;
	private String is_used;
	private Set<User> set=new HashSet<User>();
	public Department() {
		super();
	}
	public Department(Integer department_id, String department_name, String department_desc, String is_used) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_desc = department_desc;
		this.is_used = is_used;
	}
	public Set<User> getSet() {
		return set;
	}
	public void setSet(Set<User> set) {
		this.set = set;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_desc() {
		return department_desc;
	}
	public void setDepartment_desc(String department_desc) {
		this.department_desc = department_desc;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_desc=" + department_desc + ", is_used=" + is_used + "]";
	}
}
