package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.web.querybean;

public class QueryVO {
	private String queryContent;
	private String queryWay;
	public String getQueryContent() {
		return queryContent;
	}
	public void setQueryContent(String queryContent) {
		this.queryContent = queryContent;
	}
	public String getQueryWay() {
		return queryWay;
	}
	public void setQueryWay(String queryWay) {
		this.queryWay = queryWay;
	}
	@Override
	public String toString() {
		return "QueryVO [queryContent=" + queryContent + ", queryWay=" + queryWay + "]";
	}
	public QueryVO(String queryContent, String queryWay) {
		super();
		this.queryContent = queryContent;
		this.queryWay = queryWay;
	}
	public QueryVO() {
		super();
	}
	
}
