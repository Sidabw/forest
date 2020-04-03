package com.Java.bak.middle.Day04.src.com.zpark.pojo;

import org.springframework.stereotype.Component;

@Component("rose")
public class Rose {
	private String color;
	private int count;
	public Rose(String color, int count) {
		super();
		this.color = color;
		this.count = count;
	}
	public Rose() {
		super();
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Rose [color=" + color + ", count=" + count + "]";
	}
}
