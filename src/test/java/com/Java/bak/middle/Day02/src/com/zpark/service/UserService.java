package com.Java.bak.middle.Day02.src.com.zpark.service;

import java.util.List;

import com.zpark.entity.User;

public interface UserService {
	boolean adduser(User user);
	List<User> queryAll();
}
