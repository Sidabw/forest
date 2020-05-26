package com.Java.bak.middle.Day01.src.com.zpark.a4util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil
{
	private static String url;
	private static String username;
	private static String password;
	private static String driver;

	static{
		try
		{
			Properties properties = new Properties();
			properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("Jdbc.Properties"));
			String type=properties.getProperty("type");
			url=properties.getProperty(type+"url");
			username=properties.getProperty(type+"user");
			password=properties.getProperty(type+"password");
			driver=properties.getProperty(type+"driverClass");
			Class.forName(driver);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection connection =null;
		try
		{
			connection=DriverManager.getConnection(url,username,password);
			
		}
		catch (SQLException e)
		{
			System.out.println("url:["+url+"],username:["+username+"],passsword:["+password+"]");
			e.printStackTrace();
		}
		return connection;
	}
	public static PreparedStatement getPreparedStatement(Connection connection,String sql){
		PreparedStatement preparedStatement=null;
		try
		{
			preparedStatement=connection.prepareStatement(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return preparedStatement;
	}
	public static void close(ResultSet rs,PreparedStatement ps,Connection connection){
		try
		{
			rs.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			ps.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps, Connection connection)
	{	
		try
		{
			ps.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

