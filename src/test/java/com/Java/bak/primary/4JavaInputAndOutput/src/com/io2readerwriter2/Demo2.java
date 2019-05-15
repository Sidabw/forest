package com.io2readerwriter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * �ֽ������ֽ�����ȡ�����ļ��Ķ��������ݣ�������������Ҫ(char)content��new String(buf)��������������ȡ�����ݡ�
 * 
 * �ַ������ַ���=�ֽ���+����
 * 
 * 
 * 
 * �����ַ�����
 * ---------|Reader�������ַ����Ļ��࣬��abstract
 * -----------|FileReader����ȡ�ļ��������ַ���
 * */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		readerTest2(); 
	}
	//ʹ�û����ַ������ȡ�ļ�
	public static void readerTest2() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileReader fileReader =new FileReader(file);
		char[] buf=new char[1024];
		int length=0;
		while((length=fileReader.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,length));
		}
		fileReader.close();		
	}
	public static void readerTest() throws IOException
	{
		//�ҵ�Ŀ���ļ�
		File file =new File("D:\\a.txt");
		//�������ݵ�����ͨ��
		FileReader fileReader =new FileReader(file);
		int content=0;
		while((content=fileReader.read())!=-1)
		{
			System.out.print((char)content);
		}
		fileReader.close();
	}
}
