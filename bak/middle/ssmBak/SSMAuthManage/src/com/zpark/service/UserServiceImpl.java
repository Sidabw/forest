package com.Java.bak.middle.ssmBak.SSMAuthManage.src.com.zpark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpark.dao.StudentMapper;
import com.zpark.web.pojo.Student;
import com.zpark.web.pojo.VO;
@Service("us")
public class UserServiceImpl implements IUserService {

	@Autowired
	private StudentMapper sm;
	@Override
	public Student findById(Integer id) {
		Student student = sm.selectByPrimaryKey(id);
		return student;
	}
	@Override
	public List<Student> list() {
		return sm.list();
	}
	@Override
	public void batchDel(List<Integer> ids) {
		for(Integer id:ids){
			sm.deleteByPrimaryKey(id);
		}
	}
	@Override
	public boolean update(VO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
