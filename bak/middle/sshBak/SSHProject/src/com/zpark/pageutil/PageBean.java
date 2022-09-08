package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.pageutil;

import java.util.List;

public class PageBean<T> {
	private Integer size=6;	//每页显示多少数据
	private Integer currentPage=1;	//当前页
	private Integer rowCount;	//总记录条数
	protected List<T> list;
	private Integer pageCount;	//总页数	rowCount/size
	
	private Integer startRow;	//每页第一行数据在数据库表中的位置
	
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
		//计算当前页
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
		//根据总条数和每页显示多少条计算出总页数
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
