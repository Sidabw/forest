package com.io2readerwriter1;
/*
 *\r��\n��������ϵ��\r�ǻس�����˼�ǽ�����Ƶ���ǰ�е�����
 *				  \n�ǻ��У���˼�ǽ�����Ƶ���ǰ�е���һ�� 
 * 
 * 
 *  * �����ַ�����
 * ---------|Reader�������ַ����Ļ��࣬��abstract
 * -----------|FileReader����ȡ�ļ��������ַ���
 * -----------|BufferedRead:���������ַ��������FileReader��ȡ�ļ���Ч�ʣ�����չFileReader�Ĺ���
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		//bufferedTest();
		System.out.println(myReadLine(new FileReader("D:\\a.txt")));
	}
	
	//����bufferedReader��readLine������һ�У�readLine���ص���String
	public static void bufferedTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileReader fileReader =new FileReader(file);
		BufferedReader bufferedReader =new BufferedReader(fileReader);
		String line;
		while((line=bufferedReader.readLine())!=null)
		{
			System.out.println(line);
		}
	}	
	//�Զ���readLine()����
	public static String myReadLine(FileReader fileReader) throws IOException
	{
		StringBuilder stringBuilder =new StringBuilder();
		int content=0;
		while((content=fileReader.read())!=-1)		//���ص����ַ������intֵ
		{
			if(content=='\r')
			{
				continue;		
			}
			else if(content=='\n')
			{
				fileReader.close();
				return new String(stringBuilder);
			}
			else {
				stringBuilder.append((char)content);	//Ҫ��intֵǿתΪchar����ӵ�StringBuilder��
				}
		}
		fileReader.close();
		return null;
	}
}


