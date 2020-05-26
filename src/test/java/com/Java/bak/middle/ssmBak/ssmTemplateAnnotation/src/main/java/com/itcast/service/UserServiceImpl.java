package com.Java.bak.middle.ssmBak.ssmTemplateAnnotation.src.main.java.com.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.mybatis.TbUser;
import com.itcast.mybatis.TbUserMapper;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private TbUserMapper tbUserMapper;
	
	public TbUser getUserById(int id) {
		return tbUserMapper.selectByPrimaryKey(new Long(id));
	}

}
