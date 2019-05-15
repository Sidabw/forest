package com.ego.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ego.mapper.UserInfoMapper;
import com.ego.pojo.UserInfo;

@Service
public class TestS {
	@Autowired
	private UserInfoMapper us;
	public void tests(){
		UserInfo userInfo = us.selectByPrimaryKey(7);
		System.out.println(userInfo);
		System.out.println("TestS.............");
	}
}
