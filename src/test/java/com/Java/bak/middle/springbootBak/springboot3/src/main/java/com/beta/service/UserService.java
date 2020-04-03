package com.Java.bak.middle.springbootBak.springboot3.src.main.java.com.beta.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.beta.pojo.TbUser;

@Service
public class UserService implements IUserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<TbUser> queryList() {
		// TODO Auto-generated method stub
		List<TbUser> queryForList = jdbcTemplate.query("select * from tb_user where id=?",new Object[]{7},new BeanPropertyRowMapper(TbUser.class));
		return queryForList;
	}

}
