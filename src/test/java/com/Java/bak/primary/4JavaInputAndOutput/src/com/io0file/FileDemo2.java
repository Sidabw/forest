package com.io0file;
/*
 * 路径问题：
 * 		1.绝对路径：该文件在硬盘上完整路径，一般以盘符开头	D:\\Zi.class
 * 		2.相对路径：资源文件相对于当前程序所在的路径，资源文件必须与当前程序在同一盘下	.  当前路径	.. 上一级路径	..\\..\\Zi.class				
 * */
import java.io.File;

public class FileDemo2 {
	public static void main(String[] args) {
		File file2 =new File(".");
		System.out.println("当前路径："+file2.getAbsolutePath());//当前路径为Beijing19工程所在位置
		File file =new File("..\\..\\Zi.class");	//相对路径，上二级路径
		System.out.println(file.exists());
	}
}
