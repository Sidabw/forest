package com.io1file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 练习：利用缓冲输入输出字节流从拷贝一个图片
 * */
public class BufferOutputStreamTest2 {
	public static void main(String[] args) throws IOException {
//		File infile =new File("D:\\4387081982.pdf");
//		File outfile=new File("E:\\4387081982.pdf");
//		
//		FileInputStream fileInputStream=new FileInputStream(infile);
//		FileOutputStream fileOutputStream=new FileOutputStream(outfile);
		
		BufferedInputStream bufferedInputStream =new BufferedInputStream(new FileInputStream("D:\\4387081982.pdf"));
		BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream("E:\\4387081982.pdf"));
		
		int content=0;
		while((content=bufferedInputStream.read())!=-1)
		{
			bufferedOutputStream.write(content);
		//	bufferedOutputStream.flush();		//不需要flush，字节满时自动写入
		}
		
		bufferedOutputStream.close();		//只需要关bufferinputstream，fileInputStream就不需要关了
		bufferedInputStream.close();	
	}	
}
