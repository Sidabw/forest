package com.io0file;
/*
 * 创建：
 * 		createNewFile()	在指定位置创建一个空文件，成功就返回true，如果已存在就不创建然后返回false
		mkdir()			在指定位置创建目录，这只会创建最后一级目录，如果上级目录不存在就抛异常。
		mkdirs()		在指定位置创建目录，这会创建路径中所有不存在的目录。
		renameTo(File dest)	重命名文件或文件夹，也可以操作非空的文件夹，文件不同时相当于文件的剪切,剪切时候不能操作非空的文件夹。
							移动/重命名成功则返回true，失败则返回false。

 * */

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
	public static void main(String[] args)throws IOException {
		
		File file=new File("D:\\lblbt.txt");
		System.out.println("创建成功了吗？"+file.createNewFile());	//创建文件
		File dir=new File("D:\\JavaDir");
		System.out.println("创建文件夹成功了吗？"+dir.mkdir());	//创建的只能是文件夹，只能创建一级
		File dir2=new File("D:\\JavaDir2\\a\\b");
		System.out.println("创建多级文件夹成功？"+dir2.mkdirs());
		
		File destFile=new File("D:\\lblbt520");
		System.out.println("重命成功吗？"+file.renameTo(destFile));	//同一路径重命名，不同路径剪切，只能剪切文件，剪切到destFile目录下
		
	}	
}
