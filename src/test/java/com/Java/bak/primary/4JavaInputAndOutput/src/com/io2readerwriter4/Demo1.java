package com.io2readerwriter4;
/*
 * FileWriterʹ��ע�⣺
 * 		1.FileWriter�ڲ�ά����һ��1024�����飬���Ȱ����ݸ�1024�����ء���ˢ�»����������д�����ĵ���
 * 
 * 
 * ʲôʱ��ʹ���ַ�����ʲôʱ��ʹ���ֽ�����
 * 
 * 		�ַ���Ӧ�ó�������д�ַ�����ʱ�����֡�Ӣ�ĵȣ���word
 * 		�ֽ���Ӧ�ó���������Ҫת��Ϊ�ַ�ʱ����ͼƬ����Ƶ��mp3��
 * 
 * 
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		 //writerTest();
		copyTest();
	}
	public static void writerTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileWriter fileWriter =new FileWriter(file,true);
		String data="dajih��";
		fileWriter.write(data);//	����Ҫ��data.getByte();,fileWriter�����Խ����write(String str)����
		//fileWriter.flush();
		fileWriter.close();
	}
	
	//ʹ��FileReader��FileWriter����ͼƬ
	//FileReaderĬ��ʹ�õ�gbk�����˫�ֽڱ��룬���֣�ͼ�η��ţ��������65536���������Щ������û�ж�Ӧ���ַ��ġ���ʱ�᷵��һ��δ֪�ַ���δ֪�ַ�ռ1���ֽڣ�����������ʧ���ļ���С��
	//����ͼƬ�Ŀ�����Ҫʹ���ֽ���
	public static void copyTest() throws IOException
	{
		File file=new File("D:\\20170507150027.png");
		File file2=new File("E:\\20170507150027.png");
		FileReader fileReader =new FileReader(file);
		FileWriter fileWriter = new FileWriter(file2);
		int content=0;												//int length=0; char[] buf=new char[];
		while((content=fileReader.read())!=-1)						//length=fileReader.read(buf)
		{
			fileWriter.write(content);								//fileWriter.write(buf,o,length)
		}
		fileWriter.close();
		fileReader.close();
		
	}
}
