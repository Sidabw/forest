package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import com.zpark.pageutil.PageBean;
import com.zpark.pojo.DepartmentInfo;
import com.zpark.pojo.QueryVO;
import com.zpark.pojo.UserInfo;
import com.zpark.pojo.UserRole;

public interface IUserInfoService {
	UserInfo login(UserInfo u);

	void empAdd(UserInfo user);
	
	void deptAdd(DepartmentInfo dept);

	void roleAdd(UserRole userRole);

	List<UserInfo> userList(QueryVO queryVO, PageBean pageBean);

	void export(String[] titles, ServletOutputStream out);
	
}
