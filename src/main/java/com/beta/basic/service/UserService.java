package com.beta.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.basic.mybatis.mapper.TbUser;
import com.beta.basic.mybatis.mapper.TbUserExample;
import com.beta.basic.mybatis.mapper.TbUserMapper;

@Service
public class UserService implements IUserService{


	@Override
	public List<TbUser> queryList() {
		return null;
	}


}
