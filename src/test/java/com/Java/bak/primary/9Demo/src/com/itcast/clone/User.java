package com.itcast.clone;

public class User implements Cloneable {
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public User() {
		super();
	}

	@Override
	protected User clone() throws CloneNotSupportedException {
		return (User) super.clone();
	}
}
