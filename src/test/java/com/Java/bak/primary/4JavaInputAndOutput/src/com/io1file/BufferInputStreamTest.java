package com.io1file;
/*
 * BufferInputStream ���������ֽ����������ڲ�ά����һ��8kb���ֽ����顣
 * 							1.�ҵ�Ŀ���ļ�
 * 							2.�������ݵ�����ͨ��
 * 							3.�������������ֽ���		���Զ��建���ֽ������ʱ����ҪfileInputStream.read(buf)��
 * 							4.�ر���Դ
 * */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInputStreamTest {
	public static void main(String[] args) throws IOException {
		readTest();
		
	}
	public static void readTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileInputStream fileInputStream =new FileInputStream(file);
		BufferedInputStream bufferedInputStream =new BufferedInputStream(fileInputStream);
		int content=0;
		while((content=bufferedInputStream.read())!=-1)
		{
			System.out.print((char)content);
		}
		bufferedInputStream.close();
	}
}
