package com.io1file;
/*
 * ����ֽ�����
 * 
 * 
 * ------|OutputStream ����������ֽ����ĸ���
 * ---------|FileOutputStream ���ļ�������ݵ�����ֽ���
 * 
 * ע�⣺1.��FileOutputStream��write��int b������д������ʱ����Ȼ���յ���һ��int���͵����ݣ���������д����ֻ��һ���ֽڵ����ݣ�ֻ�ǵ�8λ������д����ʣ�µ�ȫ������
 * 		2.�ر���Դԭ���ȿ���أ����ȹ�
 * 		3.ÿ�´���FileOutputStream�����ڲ�ά����ָ���ָ��ʼλ�á�����FileOutputStream�Ѵ����ã�����Ҫ�ڹ��캯����true׷�����ݣ�write������һֱ��ӣ���Ϊָ�����ƶ�
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
		FileOutputStream fileOutputStream=new FileOutputStream(file);//���D:\\Ŀ¼��û��a.txt ���Զ�����,Ŀ���ļ�����ʱ������ͨ��ʱ���Ȱ��ļ�������� 
		fileOutputStream.write('x');			
		fileOutputStream.close();	
	}
	//ʹ���ֽ����������д��
	public static void writeTest2()throws IOException 
	{
		File file =new File("D:\\a.txt");
		FileOutputStream fileOutputStream=new FileOutputStream(file,true);//��ԭ�����ݵĻ�����׷�����ݣ����ĵ�ĩβ׷�ӡ�
		String data="\r\nhello luobo";
		fileOutputStream.write(data.getBytes());
		fileOutputStream.close();
		
	}
	//ͨ��read  write ����ļ��Ŀ���		
	public static void copyTest()throws IOException
	{
		File file=new File("D:\\4387081982.pdf");
		File file2=new File("E:\\4387081982.pdf");
		FileInputStream fileInputStream=new FileInputStream(file);
		FileOutputStream fileOutputStream =new FileOutputStream(file2);
		int length=0;
		byte[] buf=new byte[1024];//���100kb
		while((length=fileInputStream.read(buf))!=-1)
		{
			fileOutputStream.write(buf,0,length);//��0�ֽڿ�ʼд��дlength���ֽڳ��ȶ�����
		}
		fileOutputStream.close();
		fileInputStream.close();
	}

}
