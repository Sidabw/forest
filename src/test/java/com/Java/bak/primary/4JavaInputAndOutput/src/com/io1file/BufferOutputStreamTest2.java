package com.io1file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ��ϰ�����û�����������ֽ����ӿ���һ��ͼƬ
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
		//	bufferedOutputStream.flush();		//����Ҫflush���ֽ���ʱ�Զ�д��
		}
		
		bufferedOutputStream.close();		//ֻ��Ҫ��bufferinputstream��fileInputStream�Ͳ���Ҫ����
		bufferedInputStream.close();	
	}	
}
