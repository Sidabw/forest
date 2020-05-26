package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.web.pojo;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Integer role_id;
	private String role_name;
	private Integer role_power;
	private String is_used;
	private Set<User> set=new HashSet<User>();
	public Role() {
		super();
	}
	public Role(Integer role_id, String role_name, Integer role_power, String is_used, Set<User> set) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_power = role_power;
		this.is_used = is_used;
		this.set = set;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Integer getRole_power() {
		return role_power;
	}
	public void setRole_power(Integer role_power) {
		this.role_power = role_power;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	public Set<User> getSet() {
		return set;
	}
	public void setSet(Set<User> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_power=" + role_power + ", is_used="
				+ is_used + ", set=" + set + "]";
	}
	
}
