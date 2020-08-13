package com.Java.bak.middle.DWR2.src.com.zpark.service;

import java.util.List;

import com.zpark.pojo.User;

public interface IUserService {
	User find(User u);
	List<String> findTel();
}