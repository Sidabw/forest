package com.io2readerwriter1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ----|Writer	所有输出字符流的基类   抽象类
 * ------|FileWriter 向文件输出数据的输出字符流
 * ------|BufferedWriter 缓冲输出字符流  提高FileWriter的效率，并扩展FileWriter的功能
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
		String string="zhangsan张三";
		bufferedWriter.newLine();	//实际上就是向文件输出\r\n
		bufferedWriter.write(string);
		bufferedWriter.close();
		
	}
}
