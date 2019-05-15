package com.io0file;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo6 {
	public static void main(String[] args) {
		File dir=new File("D:/javaLL/Beijing19/src/com/filetest");
		System.out.println("\t");
		listFile2(dir);
//		findJava(dir);
		
	}
	//列出指定目录下的.java文件
//	public static void findJava(File dir)
//	{
//		File[] files=dir.listFiles();//获取所有子文件及子文件夹
//		for(File file:files)
//		{
//			if(file.getName().endsWith(".java")&&file.isFile())	//保证是以.java结尾而且不是文件夹
//				System.out.println(file.getName());
//		}
//	}
//	
	//列出指定目录下的文件....   文件夹.....
	public static void listFile(File dir)	
	{
		File[] files=dir.listFiles();
		System.out.println("文件：");
		for(File item:files)
		{
			if(item.isFile())								//手动过滤
				System.out.println("\t"+item.getName());
		}
		System.out.println("文件夹");
		for(File item:files)
		{
			if(item.isDirectory())
				System.out.println("\t"+item.getName());
		}
	}
	public static void listFile2(File dir)
	{
		File[] files2=dir.listFiles(new MyFilter());		//传一个自定义过滤器，返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null
		for(File file:files2)
		{
			System.out.println(file.getName());
		}
	}

}
class MyFilter implements FilenameFilter
{

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith("java");
	}
		
}
