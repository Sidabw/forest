package com.io2readerwriter3;

import java.io.File;

/*
 * �ݹ飺����������������Լ�
 * */
public class Demo4 {
	public static void main(String[] args) {
//		File dir=new File("D:\\AndroidEclipse");
//		readAllDir(dir,"|-");
		
		
//		readDir();
//		System.out.println("5�Ľ׳��ǣ�"+test(5));
		
		delnov(new File("D:\\A"));
		
	}
	//5�Ľ׳�
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
	//�г�һ���ļ����µ����ļ�
	public static void readDir()
	{
		File dir =new File("D:\\AndroidEclipse");
		File[] files=dir.listFiles();
		for(File file:files)
		{
			System.out.println(file.getName());
		}
	}
	//�г�һ���ļ����µ����������ļ�
	public static void readAllDir(File dir,String space)
	{
		File[] files=dir.listFiles();
		for(File file:files)
		{
			if(file.isFile())
			{
				System.out.println(space+"�ļ�"+file.getName());
			}
			else if(file.isDirectory())
			{
				System.out.println(space+"�ļ���"+file.getName()); 
				readAllDir(file,"| "+space);
			}
		}
	}
	//ɾ��һ���ǿ��ļ���,��File ��� Delete����ɾ��һ��Ŀ¼ʱ��Ŀ¼����Ϊ�ղſ�ɾ�������򷵻�flase
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
