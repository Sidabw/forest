package com.io1file;
/*
 * io�����ࣺ
 * �������ݵ����򻮷�
 * 		1.������	�����������  �ļ�������
 *		2.�����
 *
 * ���ݴ���ĵ�λ���֣�
 * 		1.�ֽ�������ȡ�����ļ��еĶ��������ݣ���ȡ���Ķ��������ݲ������κδ���
 * 			
 * 		2.�ַ�������ȡ�����������ַ�Ϊ��λ�ġ��ַ�����ȡ��ͬ���Ƕ��������ݣ����������Щ����������ת����������ʶ����ַ�
 * 				�ַ���=�ֽ���+����
 * 
 * 
 * 
 * �ֽ���
 * ------|InputStream ���������ֽ����Ļ���	������
 * ---------|FileInputStream ��ȡ�ļ��������ֽ���
 *  			1.�ҵ�Ŀ���ļ� File file= new File();
 *  			2.�������ݵ�����ͨ�� FileOutputStream fileOutputStream=new FileOutputStream(file);
 *  			3.��ȡ�ļ��е�����
 *  			4.�ر���Դ
 * 
 * 
 * fileInpuStream.read()�������������ݣ�content���������ֽڣ������Ҫcharǿת
 * fileInputStream.read(buf) �����Ƕ�buf.length���ȵ����ݣ�������buf�����ص���length
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
		//�ҵ�Ŀ���ļ�
		File file =new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");
		//�������ݵ�����ͨ��
		FileInputStream fileInputStream=new FileInputStream(file);
		//��ȡ�ļ��е�����
		int content =fileInputStream.read();		//fileInputStream.read()���׳�IOException
		System.out.println("��ȡ��������"+content);//---->���ܶ�ȡȫ�����ݣ�ֻ�ܶ�ȡһ���ֽ�
		//�ر���Դ
		fileInputStream.close();
	}
	//ʹ��ѭ����ȡ�ļ�������,read one by one.
	public static void readFile2() throws IOException
	{
		long startTime=System.currentTimeMillis();
		File file=new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");	
		FileInputStream fileInputStream=new FileInputStream(file);
		int content=0;
			while((content=fileInputStream.read())!=-1)		//fileInputStream.read()�᷵����һ�������ֽڣ�����Ѿ�����ĩβ���򷵻�-1
			{
				System.out.println((char)content);		//��ÿ���ַ���ASCii��תΪchar����
			}
		fileInputStream.close();
		long endTime=System.currentTimeMillis();
		System.out.println("ʱ���Ϊ��"+(endTime-startTime));
		
	}
	//ʹ�û��������ȡ		ȱ�㣺���ܶ�ȡһ���������ļ�
	public static void readFile3()throws IOException
	{
		File file =new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");
		FileInputStream fileInputStream=new FileInputStream(file);
		//���������ֽ�����
		byte[] buf=new byte[20];
		int length=fileInputStream.read(buf);//�Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte ������,
											//	���ض��뻺�������ֽ������������Ϊ�Ѿ������ļ�ĩβ��û�и�������ݣ��򷵻� -1�� 
		System.out.println(length);
		String content=new String(buf, 0, length);	//ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte ����,��ʼ0������length
		System.out.println(content);
		fileInputStream.close();	
	}
	//ʹ�û����������ѭ�����,��������Ч��Ҫ���Ը���readFile2.
	public static void readFile4()throws IOException
	{
		long startTime=System.currentTimeMillis();
		File file =new File("D:/javaLL/Beijing19/src/com/filetest/a.txt");
		FileInputStream fileInputStream=new FileInputStream(file);
		int length=0;
		byte[] buf=new byte[4];//��������һ����1024�ı�������1024 2048... һ�㻺������Խ��Ч��Խ��,
		while((length=fileInputStream.read(buf))!=-1)	//read�����ݸ�buf���������ݵĳ���
		{
			System.out.println(new String(buf,0,length));//�������0��length  ��Ϊbuf��ÿ�ζ��Ǹ��ǲ������
		}
		fileInputStream.close();
		long endTime=System.currentTimeMillis();
		System.out.println("ʱ���Ϊ��"+(endTime-startTime));
	}
}
