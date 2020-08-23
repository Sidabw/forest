package com.beta.basic.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.beta.basic.dao.mapper.TbUser;


public interface IUserService {
	public List<TbUser> queryList();
    boolean binaryImageDbStorage(String filename, InputStream fileInputStream) throws IOException;

    boolean binaryImageDbRead(String id);

    String transactionalTest();

}
