package com.io0file;
/*
 * File��3�ֹ��췽��
 * File(String pathName)	 ͨ��������·�����ַ���ת��Ϊ����·����������һ���� File ʵ��
 * File(File parent,String child)	���� parent ����·������ child ·�����ַ�������һ���� File ʵ��
 * File(String parent,String child)
 * 
 * 
 * Ŀ¼�ָ�����
 * 		windows  \         Linux	/
 * ��
 * */
import java.io.File;

public class FileDemo1 {
	public static void main(String[] args) {
//		File file =new File("D:\\Zi.class");
//		System.out.println(file.exists());	//�鿴�ļ��Ƿ����
//		
//		File file2 =new File("D:\\Ѹ��");
//		System.out.println(file2.exists());	//�鿴�ļ����Ƿ����
		File file3=new File("D:/", "Zi.class");	//windos��Ŀ¼�ָ�����\\  ��    /	���� 
		System.out.println(file3.exists());
		

	}
	public static void childTest(String child)		//����ָ����·���µĲ�ͬ��·��
	{
		File fileParent =new File("D:"+File.separator);	// File.separator ��ϵͳ�йص�Ĭ�����Ʒָ���
		File file =new File(fileParent,child);
	}

}
