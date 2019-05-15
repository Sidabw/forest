package com.io2readerwriter3;

import java.io.File;

/*
 * 递归：函数的自身调用了自己
 * */
public class Demo4 {
	public static void main(String[] args) {
//		File dir=new File("D:\\AndroidEclipse");
//		readAllDir(dir,"|-");
		
		
//		readDir();
//		System.out.println("5的阶乘是："+test(5));
		
		delnov(new File("D:\\A"));
		
	}
	//5的阶乘
	public static int test(int num)
	{
		if(num==1)
		{
			return 1;
			
		}
		else
		{
			return num*test(num-1);
		}
	}
	//列出一个文件夹下的子文件
	public static void readDir()
	{
		File dir =new File("D:\\AndroidEclipse");
		File[] files=dir.listFiles();
		for(File file:files)
		{
			System.out.println(file.getName());
		}
	}
	//列出一个文件夹下的所有子孙文件
	public static void readAllDir(File dir,String space)
	{
		File[] files=dir.listFiles();
		for(File file:files)
		{
			if(file.isFile())
			{
				System.out.println(space+"文件"+file.getName());
			}
			else if(file.isDirectory())
			{
				System.out.println(space+"文件夹"+file.getName()); 
				readAllDir(file,"| "+space);
			}
		}
	}
	//删除一个非空文件夹,用File 里的 Delete方法删除一个目录时，目录必须为空才可删除，否则返回flase
	public static void delnov(File dir)
	{
		 File[] files=dir.listFiles();
		 for(File file:files)
		 {
			 if(file.isFile())
			 {
				 file.delete();
			 }
			 else if(file.isDirectory()){
				 delnov(file);
			 }
		 }
		 dir.delete();
	}
}
