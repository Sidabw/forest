package com.io2readerwriter1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * System.in: 字段in:public static final InputStream in
 * 
 * Scanner构造方法： Scanner(InputStream source)
 * 			.next()方法：查找并返回来自此扫描器的下一个完整标记
 * 
 * */
public class Login {
	static Scanner scanner=new Scanner(System.in);	
	public static void main(String[] args) throws IOException {
		while(true)
		{
			System.out.println("请选择功能：A（注册）	B（登录)");
			String option=scanner.next();	//查找并返回来自此扫描器的下一个完整标记
			if("a".equalsIgnoreCase(option))
			{
				//选择了注册
				reg();
				//break;
			}
			else if("b".equalsIgnoreCase(option))
			{
				login();
				//break;
			}
			else {
				System.out.println("您的输入有误，请您重新输入");
			}
		}
	}
	public static void reg() throws IOException
	{
		System.out.println("请输入您的用户名：");
		String userName=scanner.next();
		System.out.println("请输入您的密码：");
		String password=scanner.next();
		File file =new File("D:\\a.txt");
		FileWriter fileWriter=new FileWriter(file,true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		bufferedWriter.write(userName+" "+password);
		bufferedWriter.newLine();//需要换行，不然下次读文件的时候就不能用readLine方法了
		bufferedWriter.close();
	}
	public static void login() throws IOException
	{
		System.out.println("请输入您的用户名：");
		String userName=scanner.next();
		System.out.println("请输入您的密码：");
		String password=scanner.next();
		String inof=userName+" "+password;
		FileReader fileReader =new FileReader("D:\\a.txt");
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String line=null;
		boolean isLogin=false;
		while((line=bufferedReader.readLine())!=null)
		{
			if(inof.equals(line)){
				isLogin=true;
			}
		}
		if(isLogin)
		{
			System.out.println("欢迎"+userName+"登录成功");
		}
		else {
			System.out.println("不存在该用户信息");
		}
		
	}
}
