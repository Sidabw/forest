package com.Java.bak.middle.Day02.src.com.zpark.dao;

import java.util.List;

import com.zpark.entity.User;

public interface UserDao {
	boolean daoAddUser(User user);
	List<User> daoQueryAll();
}
