package com.grammer.test;
import java.io.File;
import java.io.FileFilter;

public class Demo9 {
	public static void main(String[] args) {
		filterFile(new File("c:/aaa"));
	}
	/*
	 * ������ɸѡ��ָ���ļ����µ�С��200K��С�ļ���ȡ����ӡ
	 */
	public static void filterFile(File f){
		if(f.isFile()){
			System.out.println(f + "�����ļ���");
			return;
		}
		if(!f.exists()) return;
		// ����ļ�����
		File files[] = f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// �ж��Ƿ����ļ��У�������򷵻�true
				if(pathname.isDirectory()) return true;
				// �ж��Ƿ��������ļ�
				if(pathname.isHidden()) return false;
				// ����ļ���С
				long length = pathname.length();
				if(length / 1024 < 200) return true;
				return false;
			}
		});
		
		// ��������
		for (File file : files) {
			if(file.isDirectory()) {
				filterFile(file);
				continue;
			}
			System.out.println(file);
		}
	}

}
