package com.io2readerwriter3;
/*
 * 字节流
	  输入流：
 * ------|InputStream 所有输入字节流的基类	抽象类
 * ---------|FileInputStream 读取文件的输入字节流
 * ---------|FilterInputStream----->BufferedInputStream  缓冲输入字节流，该类内部维护了一个8kb的字节数组。提高FileInpuStream读取文件的效率
 *  										1.找到目标文件 File file= new File();
 *  										2.建立数据的输入通道 FileOutputStream fileOutputStream=new FileOutputStream(file);
 *  										3.读取文件中的数据
 *  										4.关闭资源
	 输出流： ------|OutputStream		是所有输出字节流的父类
 * 		    ----------|FileOutputStream 	是文件输出数据的输出字节流
 * 			----------|FilterOutputStream----->BufferedOutputStream
 * 字符流=字节流+解码
 * 
 * 字符流：
 * 输入字符流：
 *  
 * ---------|Reader：输入字符流的基类，是abstract
 * -----------|FileReader：读取文件的输入字符流
 * -----------|BufferedReader	缓冲输入字符流	提高FileReader的效率，--readLine()
 * 
 * 
 * 
 * 
 * 
 *  * ----|Writer	所有输出字符流的基类   抽象类
 * 		------|FileWriter 向文件输出数据的输出字符流
 * 		------|BufferedWriter 缓冲输出字符流  提高FileWriter的效率，并扩展FileWriter的功能 --newLine() -->\r\n
 * 
 * 
 * 
 * 编码与解码：
 * 		当编码与解码的时候指定unicode,就是utf-16,
 * */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		String string="a中国";
		byte[] buf=string.getBytes("utf-8");		//编码-----指定编码表时：byte[]=string.getBytes("gbk")
		System.out.println(Arrays.toString(buf));
		String str=new String(buf,"utf-8");	//根据指定编码表解码字节数组
		System.out.println(str);
		
		
		
		
	}
}
