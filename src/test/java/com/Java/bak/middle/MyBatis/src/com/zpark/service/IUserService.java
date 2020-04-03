package com.Java.bak.middle.MyBatis.src.com.zpark.service;

import java.util.List;

import com.zpark.pojo.User;
import com.zpark.pojo2.Student;
import com.zpark.queryvo.QueryVO;

public interface IUserService {
	void save(User u);
	User find(User u);
	void upd(User u);
	void save2(User u);
	List<User> find2(User u);
	List<User> find3(User u);
	List<User> find4(User u);
	List<User> find5(QueryVO q);
	List<User> queryMap();
	List<User> queryMap2();
	List<Student> queryInManyToMany();
	
	
	List<User> findO();
	List<User> findO2();
}
