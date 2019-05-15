package com.io0file;
/*
 	��ȡ������
getName()		��ȡ�ļ����ļ��е����ƣ��������ϼ�·����
getPath()       ���ؾ���·�������������·��������Ŀ¼Ҫָ��
getAbsolutePath()	��ȡ�ļ��ľ���·�������ļ��Ƿ����û��ϵ
length()		��ȡ�ļ��Ĵ�С���ֽ�����������ļ��������򷵻�0L��������ļ���Ҳ����0L��
getParent()		���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻�null��
lastModified()	��ȡ���һ�α��޸ĵ�ʱ�䡣



	�ļ�����أ�
staic File[] listRoots()	�г����еĸ�Ŀ¼��Window�о�������ϵͳ���̷���
list()						����Ŀ¼�µ��ļ�����Ŀ¼�������������ļ��������ļ����������᷵��null��
list(FilenameFilter filter)	����ָ����ǰĿ¼�з��Ϲ������������ļ�����Ŀ¼�������ļ����������᷵��null��
listFiles()					����Ŀ¼�µ��ļ�����Ŀ¼����File��ʵ���������������ļ��������ļ����������᷵��null��
listFiles(FilenameFilter filter)	����ָ����ǰĿ¼�з��Ϲ������������ļ�����Ŀ¼�������ļ����������᷵��null��

 * */

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileDemo5 {
	public static void main(String[] args) {
		File file =new File("D:\\lblbt520");
		System.out.println(file.exists());
		System.out.println("��ȡ�ļ�����"+file.getName());
		System.out.println("��ȡ����·��:"+file.getAbsolutePath());
		System.out.println("��ȡ�ļ���С(�ֽ���)"+file.length());
		System.out.println("��ȡ��·��"+file.getParent());
		Long lastModified=file.lastModified();
		System.out.println(lastModified);
		Date date=new Date(lastModified);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		System.out.println("��ȡ���һ���޸�ʱ�䣨����ֵ��"+simpleDateFormat.format(date));
		
		
		
/*		File[] roots=File.listRoots();	//�г����и�Ŀ¼
		for(File file :roots)
		{
			System.out.println(file);
		}
		*/
		
		/*
		File file=new File("D:\\AndroidEclipse\\adt-bundle-windows-x86_64_20140101");
		String[] fileName=file.list();	//file.list() �ѵ�ǰ�ļ����������е����ļ������ļ���������String[]����
		for(String name:fileName)
		{
			System.out.println(name);
		}
		*/
		
//		File file=new File("D:\\AndroidEclipse\\adt-bundle-windows-x86_64_20140101");
//		File[] files=file.listFiles();	//�ѵ�ǰ�ļ����µ������ļ������ļ�����file�������浽file[]�С�
//		for(File fitem:files)
//		{
//			System.out.println(fitem.getName());
//		}
		
		
		
		
	}
}
