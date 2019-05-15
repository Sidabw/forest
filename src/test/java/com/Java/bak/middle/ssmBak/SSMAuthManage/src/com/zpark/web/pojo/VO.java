package com.Java.bak.middle.ssmBak.SSMAuthManage.src.com.zpark.web.pojo;

import java.util.List;

public class VO {
	private List<Integer> ids;
	private List<Student> stus;
	private String pic;
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public VO(List<Integer> ids) {
		super();
		this.ids = ids;
	}

	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}
	public VO() {
		super();
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "VO [ids=" + ids + "]";
	}
}
