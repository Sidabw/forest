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
	//�г�ָ��Ŀ¼�µ�.java�ļ�
//	public static void findJava(File dir)
//	{
//		File[] files=dir.listFiles();//��ȡ�������ļ������ļ���
//		for(File file:files)
//		{
//			if(file.getName().endsWith(".java")&&file.isFile())	//��֤����.java��β���Ҳ����ļ���
//				System.out.println(file.getName());
//		}
//	}
//	
	//�г�ָ��Ŀ¼�µ��ļ�....   �ļ���.....
	public static void listFile(File dir)	
	{
		File[] files=dir.listFiles();
		System.out.println("�ļ���");
		for(File item:files)
		{
			if(item.isFile())								//�ֶ�����
				System.out.println("\t"+item.getName());
		}
		System.out.println("�ļ���");
		for(File item:files)
		{
			if(item.isDirectory())
				System.out.println("\t"+item.getName());
		}
	}
	public static void listFile2(File dir)
	{
		File[] files2=dir.listFiles(new MyFilter());		//��һ���Զ��������������ָ����ǰĿ¼�з��Ϲ������������ļ�����Ŀ¼�������ļ����������᷵��null
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
