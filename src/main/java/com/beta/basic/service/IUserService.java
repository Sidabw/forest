package com.beta.basic.service;

import java.util.List;

import com.beta.basic.mybatis.mapper.TbUser;


public interface IUserService {
	public List<TbUser> queryList();
}
