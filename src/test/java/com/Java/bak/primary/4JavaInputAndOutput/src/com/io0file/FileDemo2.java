package com.io0file;
/*
 * ·�����⣺
 * 		1.����·�������ļ���Ӳ��������·����һ�����̷���ͷ	D:\\Zi.class
 * 		2.���·������Դ�ļ�����ڵ�ǰ�������ڵ�·������Դ�ļ������뵱ǰ������ͬһ����	.  ��ǰ·��	.. ��һ��·��	..\\..\\Zi.class				
 * */
import java.io.File;

public class FileDemo2 {
	public static void main(String[] args) {
		File file2 =new File(".");
		System.out.println("��ǰ·����"+file2.getAbsolutePath());//��ǰ·��ΪBeijing19��������λ��
		File file =new File("..\\..\\Zi.class");	//���·�����϶���·��
		System.out.println(file.exists());
	}
}
