package com.io2readerwriter3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/*
 * ת������
 * 
 * 		�����ֽ�����ת������InputStreamReader	���ֽ���ͨ���ַ�������
 * 		����ֽ�����ת������OutputStreamWriter	
 * 
 * ���ã�
 * 		1.�����ֽ���--->�ַ���
 * 		2.����ָ��������д�ļ�
 * */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Demo3 {
	public static void main(String[] args) throws IOException {
		writerTest2();
	}
	public static void readTest() throws IOException
	{
		InputStream in=System.in;		//System.in���ص���InputStream Ҳ���Ƿ��ص����ֽ���������Ҫ���ַ�����������Ҫת���� InputStreamReader		(�ֽ���---->�ַ���)
	//	System.out.println("�������ַ��ǣ�"+(char)in.read());
		
		InputStreamReader inputStreamReader=new InputStreamReader(in);
		BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
		String line=null;
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println("�����������ǣ�"+line);
		}
	}
	public static void writerTest() throws IOException
	{
		File file=new File("D:\\a.txt");
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\a.txt");
		OutputStreamWriter outputStreamWriter =new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.write("dd");
		outputStreamWriter.close();
		//fileOutputStream.write("zhangss".getBytes());
		
		//������ֽ���ת��������ַ���
		
	}
	public static void writerTest2() throws IOException
	{
		File file=new File("D:\\a.txt");
		FileOutputStream fileOutputStream =new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");
		outputStreamWriter.write("���й�");
		outputStreamWriter.close();
	}
}