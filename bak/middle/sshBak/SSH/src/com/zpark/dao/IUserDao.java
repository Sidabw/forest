package com.Java.bak.middle.sshBak.SSH.src.com.zpark.dao;

import com.zpark.web.pojo.User;

public interface IUserDao {
	public void sava(User u);
	public User findByName();
}
