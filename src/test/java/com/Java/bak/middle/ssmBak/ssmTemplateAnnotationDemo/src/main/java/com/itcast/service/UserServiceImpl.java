package com.Java.bak.middle.ssmBak.ssmTemplateAnnotationDemo.src.main.java.com.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.mybatis.TbUser;
import com.itcast.mybatis.TbUserMapper;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Override
	public TbUser getUserById(int id) {
		// TODO Auto-generated method stub
		System.out.println("测试");
		return null;
	}

	/*@Autowired
	private TbUserMapper tbUserMapper;
	
	public TbUser getUserById(int id) {
		return tbUserMapper.selectByPrimaryKey(new Long(id));
	}*/

}
