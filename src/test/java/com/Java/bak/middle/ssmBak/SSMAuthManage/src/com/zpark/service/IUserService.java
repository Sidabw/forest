package com.Java.bak.middle.ssmBak.SSMAuthManage.src.com.zpark.service;

import java.util.List;

import com.zpark.web.pojo.Student;
import com.zpark.web.pojo.VO;

public interface IUserService {
	Student findById(Integer id);
	List<Student> list();
	void batchDel(List<Integer> ids);
	boolean update(VO vo);
}
