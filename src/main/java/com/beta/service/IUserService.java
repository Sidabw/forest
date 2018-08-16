package com.beta.service;

import java.util.List;

import com.beta.mybatis.mapper.TbUser;


public interface IUserService {
	public List<TbUser> queryList();
}
