package com.io0file;

import java.io.File;

/*
 * ɾ����
 * delete()			ɾ���ļ���һ�����ļ��У�������ļ����Ҳ�Ϊ�գ�����ɾ�����ɹ�����true��ʧ�ܷ���false��
   deleteOnExit()	�������jvm��ֹʱ������ɾ���˳���·������ʾ���ļ���Ŀ¼����֤�����쳣ʱ��������ʱ�ļ�Ҳ���Ա�ɾ��,����ֵ����void
   
       �жϣ�
     	exists()		�ļ����ļ����Ƿ���ڡ�
		isFile()		�Ƿ���һ���ļ�����������ڣ���ʼ��Ϊfalse��
		isDirectory()	�Ƿ���һ��Ŀ¼����������ڣ���ʼ��Ϊfalse��
		isHidden()		�Ƿ���һ�����ص��ļ����Ƿ������ص�Ŀ¼��
		isAbsolute()	���Դ˳���·�����Ƿ�Ϊ����·������


 * */
public class FileDemo4 {
	public static void main(String[] args) {
/*ɾ������
 * 		File file =new File("D:\\JavaDir");
		System.out.println("ɾ���ɹ���"+file.delete());
		File file2=new File("D:\\JavaDir2");
		file2.deleteOnExit();	//һ�����ڳ����˳�ʱ��ʱ�ļ���ɾ������ΪdeleteOnExit��jvm�˳�ʱ�Ż�ɾ���ļ�
		*/
		
		//�жϲ���
		File file =new File("D:\\lblbt520");
		System.out.println("������"+file.exists());
		System.out.println("��һ���ļ���"+file.isFile());
		System.out.println("��һ���ļ�����"+file.isDirectory());
		System.out.println("�������ļ���"+file.isHidden());
		System.out.println("�Ǿ���·����"+file.isAbsolute());
	}
}
