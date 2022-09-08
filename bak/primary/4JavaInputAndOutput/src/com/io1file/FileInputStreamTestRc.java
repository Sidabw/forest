package com.io1file;
/*
 * io流分类：
 * 根据数据的流向划分
 * 		1.输入流	相对与程序而言  文件流进来
 *		2.输出流
 *
 * 根据处理的单位划分：
 * 		1.字节流：读取的是文件中的二进制数据，读取到的二进制数据不会做任何处理
 * 			
 * 		2.字符流：独取的数据是以字符为单位的。字符流读取的同样是二进制数据，不过会把这些二进制数据转换成我们能识别的字符
 * 				字符流=字节流+解码
 * 
 * 
 * 
 * 字节流
 * ------|InputStream 所有输入字节流的基类	抽象类
 * ---------|FileInputStream 读取文件的输入字节流
 *  			1.找到目标文件 File file= new File();
 *  			2.建立数据的输入通道 FileOutputStream fileOutputStream=new FileOutputStream(file);
 *  			3.读取文件中的数据
 *  			4.关闭资源
 * 
 * 
 * fileInpuStream.read()方法返回是内容（content），单个字节，输出需要char强转
 * fileInputStream.read(buf) 方法是读buf.length长度的内容，并传给buf，返回的是length
 * 
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args)throws IOException {
		readFile4();
	}
	public static void readFile()throws IOException
	{
		//找到目标文件
		File file =new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");
		//建立数据的输入通道
		FileInputStream fileInputStream=new FileInputStream(file);
		//读取文件中的数据
		int content =fileInputStream.read();		//fileInputStream.read()会抛出IOException
		System.out.println("读取的内容是"+content);//---->不能读取全部内容，只能读取一个字节
		//关闭资源
		fileInputStream.close();
	}
	//使用循环读取文件的数据,read one by one.
	public static void readFile2() throws IOException
	{
		long startTime=System.currentTimeMillis();
		File file=new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");	
		FileInputStream fileInputStream=new FileInputStream(file);
		int content=0;
			while((content=fileInputStream.read())!=-1)		//fileInputStream.read()会返回下一个数据字节，如果已经到达末尾，则返回-1
			{
				System.out.println((char)content);		//把每个字符从ASCii码转为char类型
			}
		fileInputStream.close();
		long endTime=System.currentTimeMillis();
		System.out.println("时间差为："+(endTime-startTime));
		
	}
	//使用缓冲数组读取		缺点：不能读取一个完整的文件
	public static void readFile3()throws IOException
	{
		File file =new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");
		FileInputStream fileInputStream=new FileInputStream(file);
		//建立缓冲字节数组
		byte[] buf=new byte[20];
		int length=fileInputStream.read(buf);//从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中,
											//	返回读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。 
		System.out.println(length);
		String content=new String(buf, 0, length);	//通过使用平台的默认字符集解码指定的 byte 数组,开始0，长度length
		System.out.println(content);
		fileInputStream.close();	
	}
	//使用缓冲数组配合循环完成,缓冲数组效率要明显高于readFile2.
	public static void readFile4()throws IOException
	{
		long startTime=System.currentTimeMillis();
		File file =new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");
		FileInputStream fileInputStream=new FileInputStream(file);
		int length=0;
		byte[] buf=new byte[4];//缓冲数组一般是1024的倍数。如1024 2048... 一般缓冲数组越大效率越高,
		while((length=fileInputStream.read(buf))!=-1)	//read的内容给buf，返回内容的长度
		{
			System.out.println(new String(buf,0,length));//必须加上0，length  因为buf是每次都是覆盖不是清空
		}
		fileInputStream.close();
		long endTime=System.currentTimeMillis();
		System.out.println("时间差为："+(endTime-startTime));
	}
}
