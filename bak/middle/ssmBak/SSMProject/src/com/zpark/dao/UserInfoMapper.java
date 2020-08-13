package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.dao;

import java.util.List;

import com.zpark.pageutil.PageBean;
import com.zpark.pojo.DepartmentInfo;
import com.zpark.pojo.UserInfo;
import com.zpark.pojo.UserRole;

public interface UserInfoMapper {
    UserInfo selectById(UserInfo user);
    void insertUser(UserInfo user);
	void deptAdd(DepartmentInfo dept);
	void roleAdd(UserRole userRole);
	List<UserInfo> userList(PageBean pageBean);
	Integer rouCount();
	List<UserInfo> userListAll();
}