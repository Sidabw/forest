package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.pojo;

public class QueryVO {
	private String queryContent;
	private String queryType;
	public QueryVO() {
		super();
	}
	public QueryVO(String queryContent, String queryType) {
		super();
		this.queryContent = queryContent;
		this.queryType = queryType;
	}
	public String getQueryContent() {
		return queryContent;
	}
	public void setQueryContent(String queryContent) {
		this.queryContent = queryContent;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	@Override
	public String toString() {
		return "QueryVO [queryContent=" + queryContent + ", queryType=" + queryType + "]";
	}
	
}
