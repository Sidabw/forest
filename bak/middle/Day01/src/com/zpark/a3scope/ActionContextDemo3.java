package com.Java.bak.middle.Day01.src.com.zpark.a3scope;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.zpark.a4util.JdbcUtil;
import com.zpark.a4util.User;

public class ActionContextDemo3 extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;
	@Override
	public String execute() throws Exception {
		/**
		 * ͨ��ʵ��ActionSupport�е�setServletRequest������õ�HttpServletRequest��
		 * �÷�������20�����Ĺ������е�ServeletConfig����Ӧ��ServletConfigInterceptor���е��õ�,����ServletRequestAware�����������»�ȡ��Request.
		 * */
		request.setAttribute("HttpServletRequestFromServletRequestAware", "This is mora than cute");
		request.setAttribute("listUser", getDatabaseData());
		return super.execute();
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public List<User> getDatabaseData(){
		ResultSet rs=null;
		Connection connection = JdbcUtil.getConnection();
		String sql="select * from user";
		PreparedStatement ps = JdbcUtil.getPreparedStatement(connection, sql);
		List<User> listUser=new ArrayList<User>();
		try {
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setPower(rs.getString("power"));
				user.setPwd(rs.getString("pwd"));
				user.setRealname(rs.getString("realname"));
				user.setTel(rs.getString("tel"));
				user.setUname(rs.getString("uname"));
				listUser.add(user);
			}
			return listUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, ps, connection);
		}
		return listUser;
	}

}
