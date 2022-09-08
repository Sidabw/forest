package com.io1file;
/*
 * 输出字节流：
 * 
 * 
 * ------|OutputStream 是所有输出字节流的父类
 * ---------|FileOutputStream 是文件输出数据的输出字节流
 * 
 * 注意：1.用FileOutputStream的write（int b）方法写入数据时，虽然接收的是一个int类型的数据，，但真正写出的只有一个字节的数据，只是底8位的数据写出，剩下的全部丢弃
 * 		2.关闭资源原则：先开后关，后开先关
 * 		3.每新创建FileOutputStream，其内部维护的指针会指向开始位置。但若FileOutputStream已创建好，不需要在构造函数上true追加数据，write方法会一直添加，因为指针在移动
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException{
		writeTest2();
		copyTest();
	}
	public static void writeTest()throws IOException
	{
		File file =new File("D:\\a.txt");
		FileOutputStream fileOutputStream=new FileOutputStream(file);//如果D:\\目录下没有a.txt 则自动生成,目标文件存在时，建立通道时会先把文件内容清空 
		fileOutputStream.write('x');			
		fileOutputStream.close();	
	}
	//使用字节数组把数据写出
	public static void writeTest2()throws IOException 
	{
		File file =new File("D:\\a.txt");
		FileOutputStream fileOutputStream=new FileOutputStream(file,true);//在原来数据的基础上追加数据，从文档末尾追加。
		String data="\r\nhello luobo";
		fileOutputStream.write(data.getBytes());
		fileOutputStream.close();
		
	}
	//通过read  write 完成文件的拷贝		
	public static void copyTest()throws IOException
	{
		File file=new File("D:\\4387081982.pdf");
		File file2=new File("E:\\4387081982.pdf");
		FileInputStream fileInputStream=new FileInputStream(file);
		FileOutputStream fileOutputStream =new FileOutputStream(file2);
		int length=0;
		byte[] buf=new byte[1024];//最大100kb
		while((length=fileInputStream.read(buf))!=-1)
		{
			fileOutputStream.write(buf,0,length);//从0字节开始写，写length个字节长度额数据
		}
		fileOutputStream.close();
		fileInputStream.close();
	}

}
