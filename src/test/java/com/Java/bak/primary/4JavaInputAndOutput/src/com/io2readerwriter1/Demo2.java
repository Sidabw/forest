package com.io2readerwriter1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ----|Writer	��������ַ����Ļ���   ������
 * ------|FileWriter ���ļ�������ݵ�����ַ���
 * ------|BufferedWriter ��������ַ���  ���FileWriter��Ч�ʣ�����չFileWriter�Ĺ���
 * 
 * */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		bufferedWriterTest();
	}
	public static void bufferedWriterTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileWriter fileWriter =new FileWriter(file,true);
		BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
		String string="zhangsan����";
		bufferedWriter.newLine();	//ʵ���Ͼ������ļ����\r\n
		bufferedWriter.write(string);
		bufferedWriter.close();
		
	}
}
