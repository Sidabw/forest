package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.service;

import java.util.List;

import com.zpark.pageutil.PageBean;
import com.zpark.web.pojo.User;
import com.zpark.web.querybean.QueryVO;

public interface IUserService {

	void sava(User user);

	void findByName();

	User login(User user);

	List<User> findAllUser(QueryVO queryVO, PageBean pageBean);

	boolean userInfoUpdate(User user);

	Integer getUserId(User user);

	User findById(Integer user_id);
	boolean userInfoDelete(User user);

	boolean addEmployee();

	List<User> queryLimited(QueryVO queryVO);

}
