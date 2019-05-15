package com.Java.bak.middle.springbootBak.springboot4.src.main.java.com.beta.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.beta.mapper.TbUser;
import com.beta.mapper.TbUserExample;
import com.beta.mapper.TbUserMapper;

@Service
public class UserService implements IUserService{

	@Autowired
	private TbUserMapper tbUserMapper;
	@Override
	public List<TbUser> queryList() {
		// TODO Auto-generated method stub
		TbUserExample tbUserExample = new TbUserExample();
		List<TbUser> list = tbUserMapper.selectByExample(tbUserExample);
		return list;
	}

}
