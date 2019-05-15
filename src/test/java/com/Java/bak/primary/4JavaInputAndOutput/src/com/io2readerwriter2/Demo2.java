package com.io2readerwriter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 字节流：字节流读取的是文件的二进制数据，读到的数据需要(char)content或new String(buf)才能真正看到读取的内容。
 * 
 * 字符流：字符流=字节流+解码
 * 
 * 
 * 
 * 输入字符流：
 * ---------|Reader：输入字符流的基类，是abstract
 * -----------|FileReader：读取文件的输入字符流
 * */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		readerTest2(); 
	}
	//使用缓冲字符数组读取文件
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
		//找到目标文件
		File file =new File("D:\\a.txt");
		//建立数据的输入通道
		FileReader fileReader =new FileReader(file);
		int content=0;
		while((content=fileReader.read())!=-1)
		{
			System.out.print((char)content);
		}
		fileReader.close();
	}
}
