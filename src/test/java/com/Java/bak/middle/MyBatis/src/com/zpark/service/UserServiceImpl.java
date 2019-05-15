package com.Java.bak.middle.MyBatis.src.com.zpark.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zpark.dao.IUserDao;
import com.zpark.dao2.TbUser;
import com.zpark.dao2.TbUserExample;
import com.zpark.dao2.TbUserExample.Criteria;
import com.zpark.dao2.TbUserMapper;
import com.zpark.pojo.User;
import com.zpark.pojo2.Student;
import com.zpark.queryvo.QueryVO;
import com.zpark.util.MybatisUtil;

public class UserServiceImpl implements IUserService {

	/**
	 *直接通过接口，使用动态代理操作数据库 
	 * */
	@Test
	public void test(){
		//new UserServiceImpl().save(new User(null,"fffffffffff","222"));
		//User user = new UserServiceImpl().find(new User(1,null,null));
		//new UserServiceImpl().upd(new User(2,"sas","d"));
		//System.out.println(user);
		//new UserServiceImpl().save2(new User(2,"saaasssssssss","d"));
//		User user = new UserServiceImpl().find(new User(1,null,null));
//		System.out.println(user);
		List<User> list = new UserServiceImpl().find2(new User(2,"s","d"));
		System.out.println(list);
		//List<User> list = new UserServiceImpl().find4(new User(2,"b","d"));
		//System.out.println(list);
		//List<Student> list = new UserServiceImpl().queryInManyToMany();
		//System.out.println(list);
		//List<User> list = new UserServiceImpl().find5(new QueryVO());
		//System.out.println(list);
		//List<User> list = new UserServiceImpl().queryMap2();
		//System.out.println(list);
		
		/**
		 * 配置文件内的sql语句不能有分号
		 * */
//		List<User> list = new UserServiceImpl().findO();
//		System.out.println(list);
	}
	@Override
	public void save(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		mapper.save(u);
		session.commit();
	}
	@Override
	public User find(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		User find = mapper.find(1);
		return find;
	}
	@Override
	public void upd(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		mapper.upd2(u);
		session.commit();
	}
	/**
	 * 插入数据获取自增主键。获取的自增主键在操作的对象中
	 * */
	@Override
	public void save2(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		mapper.upd2(u);
		session.commit();
		System.out.println(u.getId());
	}
	/**
	 * 拼接sql 模糊查询
	 * */
	@Override
	public List<User> find2(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<User> list = (List<User>) mapper.find2(u);
		session.commit();
		return list;
	}
	@Override
	public List<User> find3(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<User> list = mapper.find3(u);
		session.commit();
		return list;
	}
	@Override
	public List<User> find4(User u) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<User> list = mapper.find4(u);
		session.commit();
		return list;
	}
	@Override
	public List<User> find5(QueryVO q) {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(0,1);
		arrayList.add(1,2);
		arrayList.add(2,3);
		q.setIds(arrayList);
		List<User> list = mapper.find5(q);
		return list;
	}
	@Override
	public List<User> queryMap() {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<User> list = mapper.queryMap();
		return list;
	}
	@Override
	public List<User> queryMap2() {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<User> list = mapper.queryMap2();
		return list;
	}
	@Override
	public List<Student> queryInManyToMany() {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<Student> list = mapper.queryInManyToMany();
		return list;
	}
	@Override
	public List<User> findO() {
		SqlSession session = MybatisUtil.getSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		List<User> list = mapper.findO();
		session.commit();
		return list;
	}
	@Override
	public List<User> findO2() {
		// TODO Auto-generated method stub
		return null;
	}

}
