package com.io0file;

import java.io.File;

/*
 * 删除：
 * delete()			删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回true，失败返回false。
   deleteOnExit()	在虚拟机jvm终止时，请求删除此抽象路径名表示的文件或目录，保证程序异常时创建的临时文件也可以被删除,返回值类型void
   
       判断：
     	exists()		文件或文件夹是否存在。
		isFile()		是否是一个文件，如果不存在，则始终为false。
		isDirectory()	是否是一个目录，如果不存在，则始终为false。
		isHidden()		是否是一个隐藏的文件或是否是隐藏的目录。
		isAbsolute()	测试此抽象路径名是否为绝对路径名。


 * */
public class FileDemo4 {
	public static void main(String[] args) {
/*删除操作
 * 		File file =new File("D:\\JavaDir");
		System.out.println("删除成功吗？"+file.delete());
		File file2=new File("D:\\JavaDir2");
		file2.deleteOnExit();	//一般用于程序退出时临时文件的删除。因为deleteOnExit在jvm退出时才会删除文件
		*/
		
		//判断操作
		File file =new File("D:\\lblbt520");
		System.out.println("存在吗？"+file.exists());
		System.out.println("是一个文件吗？"+file.isFile());
		System.out.println("是一个文件夹吗？"+file.isDirectory());
		System.out.println("是隐藏文件吗？"+file.isHidden());
		System.out.println("是绝对路径吗？"+file.isAbsolute());
	}
}
