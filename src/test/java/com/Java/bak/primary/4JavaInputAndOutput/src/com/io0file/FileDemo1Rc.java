package com.io0file;
/*
 * File类3种构造方法
 * File(String pathName)	 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例
 * File(File parent,String child)	根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例
 * File(String parent,String child)
 * 
 * 
 * 目录分隔符：
 * 		windows  \         Linux	/
 * 在
 * */
import java.io.File;

public class FileDemo1 {
	public static void main(String[] args) {
//		File file =new File("D:\\Zi.class");
//		System.out.println(file.exists());	//查看文件是否存在
//		
//		File file2 =new File("D:\\迅雷");
//		System.out.println(file2.exists());	//查看文件夹是否存在
		File file3=new File("D:/", "Zi.class");	//windos的目录分隔符认\\  和    /	两种 
		System.out.println(file3.exists());
		

	}
	public static void childTest(String child)		//操作指定父路径下的不同子路径
	{
		File fileParent =new File("D:"+File.separator);	// File.separator 与系统有关的默认名称分隔符
		File file =new File(fileParent,child);
	}

}
