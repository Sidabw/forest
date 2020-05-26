package com.io2readerwriter2;


/*
 * 码表：
 * ASCii码：美国标准信息交换吗，用1个字节的7位表示
 * 
 * GB2312: 中文编码表------->英文占1个字节，中文占两个字节。
 * */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		writeTest();
		readTest2();
	}
	public static void writeTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileOutputStream fileOutputStream =new FileOutputStream(file);//构造方法里没有true，建立通道时会先把原来的文件内容删除
		String str="大家好";	
		fileOutputStream.write(str.getBytes());
		System.out.println(Arrays.toString(str.getBytes()));		//显示getBytes()的编码内容
		fileOutputStream.close();
	}
	public static void readTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileInputStream fileInputStream =new FileInputStream(file);
		int content=0;
		while((content=fileInputStream.read())!=-1)
		{
			System.out.println((char)content);
		}
		fileInputStream.close();

	}
	
	//读取汉字，汉子是两个字节，定义循环一次读两个字节到buf，输出显示的时候要用 new String(buf)对buf解码
	public static void readTest2() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileInputStream fileInputStream =new FileInputStream(file);
		byte[] buf=new byte[2];
		for(int i=0;i<3;i++)
		{
			fileInputStream.read(buf);	//通过使用平台的默认字符集解码指定的 byte 数组
			System.out.print(new String(buf));
		}
		fileInputStream.close();
	}
}

