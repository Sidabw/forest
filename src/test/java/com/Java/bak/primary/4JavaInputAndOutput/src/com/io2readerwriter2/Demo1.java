package com.io2readerwriter2;


/*
 * ���
 * ASCii�룺������׼��Ϣ��������1���ֽڵ�7λ��ʾ
 * 
 * GB2312: ���ı����------->Ӣ��ռ1���ֽڣ�����ռ�����ֽڡ�
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
		FileOutputStream fileOutputStream =new FileOutputStream(file);//���췽����û��true������ͨ��ʱ���Ȱ�ԭ�����ļ�����ɾ��
		String str="��Һ�";	
		fileOutputStream.write(str.getBytes());
		System.out.println(Arrays.toString(str.getBytes()));		//��ʾgetBytes()�ı�������
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
	
	//��ȡ���֣������������ֽڣ�����ѭ��һ�ζ������ֽڵ�buf�������ʾ��ʱ��Ҫ�� new String(buf)��buf����
	public static void readTest2() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileInputStream fileInputStream =new FileInputStream(file);
		byte[] buf=new byte[2];
		for(int i=0;i<3;i++)
		{
			fileInputStream.read(buf);	//ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte ����
			System.out.print(new String(buf));
		}
		fileInputStream.close();
	}
}

