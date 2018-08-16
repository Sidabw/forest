package com.beta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.mybatis.mapper.TbUser;
import com.beta.mybatis.mapper.TbUserExample;
import com.beta.mybatis.mapper.TbUserMapper;

@Service
public class UserService implements IUserService{

	@Autowired
	private TbUserMapper tbUserMapper;
	@Override
	public List<TbUser> queryList() {
		TbUserExample tbUserExample = new TbUserExample();
		List<TbUser> list = tbUserMapper.selectByExample(tbUserExample);
		return list;
	}

}
