package com.Java.bak.middle.sshBak.SSH.src.com.zpark.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.IUserDao;
import com.zpark.web.pojo.User;

@Service("userService")
/**
 * 分别是配置隔离级别(isolation)、传播机制(propagation)、只读
 * */
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserService implements IUserService{
	@Resource(name="userDao")
	private IUserDao userDao;
	@Transactional(isolation=Isolation.REPEATABLE_READ,readOnly=false,propagation=Propagation.REQUIRED)
	public void sava(User user) {
		userDao.sava(user);
	}
	@Override
	public void findByName() {
		userDao.findByName();
	}
	
}
