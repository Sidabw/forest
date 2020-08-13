package com.Java.bak.middle.MyBatis.src.com.zpark.dao;

import java.util.List;

import com.zpark.pojo.User;
import com.zpark.pojo2.Student;
import com.zpark.queryvo.QueryVO;

public interface IUserDao {
	void save(User u);
	User find(Integer id);
	//User find2(Integer id);
	void upd2(User u);
	void save2(User u);
	List<User> find2(User u);
	List<User> find3(User u);
	List<User> find4(User u);
	List<User> find5(QueryVO q);
	List<User> queryMap();
	List<User> queryMap2();
	List<Student> queryInManyToMany();
	
	
	List<User> findO();
}
