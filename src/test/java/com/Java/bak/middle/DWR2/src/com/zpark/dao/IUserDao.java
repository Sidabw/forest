package com.Java.bak.middle.DWR2.src.com.zpark.dao;

import java.util.List;

import com.zpark.pojo.User;

public interface IUserDao {
	User find(User u);

	List<String> findTel();
}
