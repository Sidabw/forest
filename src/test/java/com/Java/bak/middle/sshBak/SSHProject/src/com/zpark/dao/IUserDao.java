package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zpark.pageutil.PageBean;
import com.zpark.web.pojo.User;
import com.zpark.web.querybean.QueryVO;

public interface IUserDao {
	public void sava(User u);
	public User findByName();
	public User login(User user);
	public List<User> findAllUser(DetachedCriteria criteria, PageBean pageBean);
	public boolean userInfoUpdate(User user);
	public Integer getUserId(User user);
	public User findById(Integer user_id);
	public boolean userInfoDelete(User user);
	public boolean addEmployee();
	public List<User> queryLimited(DetachedCriteria criteria);
}
