package com.io0file;
/*
 * ������
 * 		createNewFile()	��ָ��λ�ô���һ�����ļ����ɹ��ͷ���true������Ѵ��ھͲ�����Ȼ�󷵻�false
		mkdir()			��ָ��λ�ô���Ŀ¼����ֻ�ᴴ�����һ��Ŀ¼������ϼ�Ŀ¼�����ھ����쳣��
		mkdirs()		��ָ��λ�ô���Ŀ¼����ᴴ��·�������в����ڵ�Ŀ¼��
		renameTo(File dest)	�������ļ����ļ��У�Ҳ���Բ����ǿյ��ļ��У��ļ���ͬʱ�൱���ļ��ļ���,����ʱ���ܲ����ǿյ��ļ��С�
							�ƶ�/�������ɹ��򷵻�true��ʧ���򷵻�false��

 * */

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
	public static void main(String[] args)throws IOException {
		
		File file=new File("D:\\lblbt.txt");
		System.out.println("�����ɹ�����"+file.createNewFile());	//�����ļ�
		File dir=new File("D:\\JavaDir");
		System.out.println("�����ļ��гɹ�����"+dir.mkdir());	//������ֻ�����ļ��У�ֻ�ܴ���һ��
		File dir2=new File("D:\\JavaDir2\\a\\b");
		System.out.println("�����༶�ļ��гɹ���"+dir2.mkdirs());
		
		File destFile=new File("D:\\lblbt520");
		System.out.println("�����ɹ���"+file.renameTo(destFile));	//ͬһ·������������ͬ·�����У�ֻ�ܼ����ļ������е�destFileĿ¼��
		
	}	
}
