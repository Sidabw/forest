package com.io2readerwriter1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * 带双引号的缓冲输入字符流	输出引号是需要System.out.println("\"");
 * 装饰者设计模式：
 * 步骤：1.装饰类内部维护着一个被装饰类
 * 		2.装饰类有着共同的父类或接口
 * 
 * 需求1：编写一个类扩展BufferedReader的功能，，增强readLine()的功能使其带行号
 * */
public class Other {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\a.txt");
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferedReader =new BufferedReader(fileReader);
		BufferedLinNum2 BufferedLinNum2=new BufferedLinNum2(bufferedReader);
		BufferedLinNum3 bufferedLinNum3 =new BufferedLinNum3(BufferedLinNum2);	//多态，父类BufferedReader的引用指向子类BufferedLineNum2的对象
		String line=null;
		while((line=bufferedLinNum3.readLine())!=null)	//		readLine（）方法内实际访问的是bufferedLinNum2的readLine方法，看方法体，多态。
		{
			System.out.println(line);
		}
		
	}
}

//需求1：编写一个类扩展BufferedReader的功能，，增强readLine()的功能使其带行号
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
//需求2:带分号的缓冲输入字符流



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
//带序号的line
class BufferedLinNum3 extends BufferedReader{	
	private BufferedReader bufferedReader;
	private int count=0;
	public BufferedLinNum3(BufferedReader bufferedReader)
	{
		super(bufferedReader);				//父类的构造方法至少会访问一次，因为父类没有无参的构造方法，所以必须手动supper。
		this.bufferedReader=bufferedReader;
	}
	
	public String readLine() throws IOException
	{
		String line=bufferedReader.readLine();	//多态，先去父类找方法找不到报错，找到了再去子类找。
		if(line==null)
		{
			return null;
		}
		line = count+line;
		count++;
		return  line;
		
	}
}

