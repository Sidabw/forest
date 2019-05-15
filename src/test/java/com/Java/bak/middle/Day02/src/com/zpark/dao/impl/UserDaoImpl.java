package com.Java.bak.middle.Day02.src.com.zpark.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zpark.a4util.JdbcUtil;
import com.zpark.dao.UserDao;
import com.zpark.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean daoAddUser(User user) {
		Connection connection=null;
		PreparedStatement ps=null;
		String sql="insert into user2 values(?,?,?)";
		connection=JdbcUtil.getConnection();
		ps=JdbcUtil.getPreparedStatement(connection, sql);
		try {
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getTel());
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
	@Override
	public List<User> daoQueryAll() {
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();
		String sql="select * from user2";
		connection=JdbcUtil.getConnection();
		ps=JdbcUtil.getPreparedStatement(connection, sql);
		try {
			rs=ps.executeQuery();
			while(rs.next()){
				User user =new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				list.add(user);
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}

}
