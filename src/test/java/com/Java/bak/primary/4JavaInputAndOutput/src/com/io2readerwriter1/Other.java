package com.io2readerwriter1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * ��˫���ŵĻ��������ַ���	�����������ҪSystem.out.println("\"");
 * װ�������ģʽ��
 * ���裺1.װ�����ڲ�ά����һ����װ����
 * 		2.װ�������Ź�ͬ�ĸ����ӿ�
 * 
 * ����1����дһ������չBufferedReader�Ĺ��ܣ�����ǿreadLine()�Ĺ���ʹ����к�
 * */
public class Other {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\a.txt");
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferedReader =new BufferedReader(fileReader);
		BufferedLinNum2 BufferedLinNum2=new BufferedLinNum2(bufferedReader);
		BufferedLinNum3 bufferedLinNum3 =new BufferedLinNum3(BufferedLinNum2);	//��̬������BufferedReader������ָ������BufferedLineNum2�Ķ���
		String line=null;
		while((line=bufferedLinNum3.readLine())!=null)	//		readLine����������ʵ�ʷ��ʵ���bufferedLinNum2��readLine�������������壬��̬��
		{
			System.out.println(line);
		}
		
	}
}

//����1����дһ������չBufferedReader�Ĺ��ܣ�����ǿreadLine()�Ĺ���ʹ����к�
class BufferedLineNum extends BufferedReader
{
	int count=0;
	public BufferedLineNum(Reader in) {
		super(in);
	}
	@Override
	public String readLine() throws IOException {
		// TODO Auto-generated method stub
		String line=super.readLine();
		if(line==null)
		{
			return line;
		}
		line=count+line;	//String= int + String
		count++;
		return line;
	}
	
}
//����2:���ֺŵĻ��������ַ���



class BufferedLinNum2 extends BufferedReader{	
	private BufferedReader bufferedReader;
	public BufferedLinNum2(BufferedReader bufferedReader)
	{
		super(bufferedReader);
		this.bufferedReader=bufferedReader;
	}
	
	public String readLine() throws IOException
	{
		String line=bufferedReader.readLine();
		if(line==null)
		{
			return null;
		}
		line = line+";";
		return  line;
		
	}
}
//����ŵ�line
class BufferedLinNum3 extends BufferedReader{	
	private BufferedReader bufferedReader;
	private int count=0;
	public BufferedLinNum3(BufferedReader bufferedReader)
	{
		super(bufferedReader);				//����Ĺ��췽�����ٻ����һ�Σ���Ϊ����û���޲εĹ��췽�������Ա����ֶ�supper��
		this.bufferedReader=bufferedReader;
	}
	
	public String readLine() throws IOException
	{
		String line=bufferedReader.readLine();	//��̬����ȥ�����ҷ����Ҳ��������ҵ�����ȥ�����ҡ�
		if(line==null)
		{
			return null;
		}
		line = count+line;
		count++;
		return  line;
		
	}
}

