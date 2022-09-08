package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.pageutil;

import java.util.List;

public class PageBean<T> {
	private Integer size=6;	//每页显示6条记录
	private Integer currentPage=1;	//当前页，默认是第一页
	private Integer rowCount;	//数据库总记录条数
	protected List<T> list;
	private Integer pageCount;	//共有多少页	rowCount/size
	
	private Integer startRow;	//分页，数据库limit第一个数据
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getStartRow() {
		return (currentPage-1)*size;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageCount() {
		Long round = Math.round(new Double(rowCount)/new Double(size));
		int pageCount = round.intValue();
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public PageBean(Integer size, Integer startRow, Integer rowCount, Integer currentPage, Integer pageCount) {
		super();
		this.size = size;
		this.startRow = startRow;
		this.rowCount = rowCount;
		this.currentPage = currentPage;
		this.pageCount = pageCount;
	}
	public PageBean() {
		super();
	}
	@Override
	public String toString() {
		return "PageBean [size=" + size + ", currentPage=" + currentPage + ", rowCount=" + rowCount + ", list=" + list
				+ ", startRow=" + startRow + ", pageCount=" + pageCount + "]";
	}
	
}
