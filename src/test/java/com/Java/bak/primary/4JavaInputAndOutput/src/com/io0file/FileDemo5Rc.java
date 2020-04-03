package com.io0file;
/*
 	获取方法：
getName()		获取文件或文件夹的名称，不包含上级路径。
getPath()       返回绝对路径，可以是相对路径，但是目录要指定
getAbsolutePath()	获取文件的绝对路径，与文件是否存在没关系
length()		获取文件的大小（字节数），如果文件不存在则返回0L，如果是文件夹也返回0L。
getParent()		返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回null。
lastModified()	获取最后一次被修改的时间。



	文件夹相关：
staic File[] listRoots()	列出所有的根目录（Window中就是所有系统的盘符）
list()						返回目录下的文件或者目录名，包含隐藏文件。对于文件这样操作会返回null。
list(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。
listFiles()					返回目录下的文件或者目录对象（File类实例），包含隐藏文件。对于文件这样操作会返回null。
listFiles(FilenameFilter filter)	返回指定当前目录中符合过滤条件的子文件或子目录。对于文件这样操作会返回null。

 * */

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileDemo5 {
	public static void main(String[] args) {
		File file =new File("D:\\lblbt520");
		System.out.println(file.exists());
		System.out.println("获取文件名："+file.getName());
		System.out.println("获取绝对路径:"+file.getAbsolutePath());
		System.out.println("获取文件大小(字节数)"+file.length());
		System.out.println("获取父路径"+file.getParent());
		Long lastModified=file.lastModified();
		System.out.println(lastModified);
		Date date=new Date(lastModified);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println("获取最后一次修改时间（毫秒值）"+simpleDateFormat.format(date));
		
		
		
/*		File[] roots=File.listRoots();	//列出所有根目录
		for(File file :roots)
		{
			System.out.println(file);
		}
		*/
		
		/*
		File file=new File("D:\\AndroidEclipse\\adt-bundle-windows-x86_64_20140101");
		String[] fileName=file.list();	//file.list() 把当前文件夹下面所有的子文件、子文件夹名字以String[]返回
		for(String name:fileName)
		{
			System.out.println(name);
		}
		*/
		
//		File file=new File("D:\\AndroidEclipse\\adt-bundle-windows-x86_64_20140101");
//		File[] files=file.listFiles();	//把当前文件夹下的所有文件或者文件夹以file描述并存到file[]中。
//		for(File fitem:files)
//		{
//			System.out.println(fitem.getName());
//		}
		
		
		
		
	}
}
