package com.Java.bak.middle.DWR2.src.com.zpark.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zpark.dao.IUserDao;
import com.zpark.pojo.User;
import com.zpark.util.MybatisUtil;

public class UserServiceImpl implements IUserService {
	@Override
	public User find(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		User find = mapper.find(u);
		return find;
	}

	@Override
	public List<String> findTel() {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<String> find = mapper.findTel();
		return find;
	}
}
