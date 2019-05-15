package com.Java.bak.middle.MyBatis.src.com.zpark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zpark.dao2.TbUser;
import com.zpark.dao2.TbUserExample;
import com.zpark.dao2.TbUserMapper;
import com.zpark.util.MybatisUtil;

/**
 * 使用generatedExample
 * */
public class GeneratedTest {
	/**
	 * 条件查询
	 * */
	@Test
	public void test1(){
		SqlSession session = MybatisUtil.getSession();
		TbUserMapper mapper = session.getMapper(TbUserMapper.class);
		TbUserExample userExample = new TbUserExample();
		userExample.or().andUsernameEqualTo("zhangsan");
		List<TbUser> list = mapper.selectByExample(userExample);
		for(TbUser user:list){
			System.out.println(user.getId());
		}
		/*userExample.or(userExample.createCriteria().andUsernameEqualTo("zhangsan"));
		List<TbUser> list = mapper.selectByExample(userExample);
		for(TbUser user:list){
			System.out.println(user.getId());
		}*/
		session.commit();
		session.close();
	}
	/**
	 * 
	 * */
	public void test2(){
		SqlSession session = MybatisUtil.getSession();
		TbUserMapper mapper = session.getMapper(TbUserMapper.class);
		
	}
}
