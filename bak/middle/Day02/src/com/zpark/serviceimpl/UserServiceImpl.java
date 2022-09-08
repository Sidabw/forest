package com.Java.bak.middle.Day02.src.com.zpark.serviceimpl;

import java.util.List;

import com.zpark.dao.impl.UserDaoImpl;
import com.zpark.entity.User;
import com.zpark.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean adduser(User user) {
		
		return new UserDaoImpl().daoAddUser(user);
	}

	@Override
	public List<User> queryAll() {
		List<User> daoQueryAll = new UserDaoImpl().daoQueryAll();
		return daoQueryAll;
	}

}
