package com.io1file;
/*
 * BufferInputStream 缓冲输入字节流，该类内部维护了一个8kb的字节数组。
 * 							1.找到目标文件
 * 							2.建立数据的输入通道
 * 							3.建立缓冲输入字节流		（自定义缓冲字节数组的时候，需要fileInputStream.read(buf)）
 * 							4.关闭资源
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
