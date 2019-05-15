package com.io2readerwriter3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/*
 * 转换流：
 * 
 * 		输入字节流的转环流：InputStreamReader	是字节流通向字符流的桥
 * 		输出字节流的转环流：OutputStreamWriter	
 * 
 * 作用：
 * 		1.可以字节流--->字符流
 * 		2.可以指定编码表读写文件
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
		InputStream in=System.in;		//System.in返回的是InputStream 也就是反回的是字节流，但需要用字符流，所以需要转换流 InputStreamReader		(字节流---->字符流)
	//	System.out.println("读到的字符是："+(char)in.read());
		
		InputStreamReader inputStreamReader=new InputStreamReader(in);
		BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
		String line=null;
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println("读到的内容是："+line);
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
		
		//把输出字节流转换成输出字符流
		
	}
	public static void writerTest2() throws IOException
	{
		File file=new File("D:\\a.txt");
		FileOutputStream fileOutputStream =new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");
		outputStreamWriter.write("新中国");
		outputStreamWriter.close();
	}
}