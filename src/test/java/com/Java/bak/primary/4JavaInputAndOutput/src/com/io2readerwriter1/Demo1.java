package com.io2readerwriter1;
/*
 *\r和\n的区别联系：\r是回车，意思是将光标移到当前行的行首
 *				  \n是换行，意思是将光标移到当前行的下一行 
 * 
 * 
 *  * 输入字符流：
 * ---------|Reader：输入字符流的基类，是abstract
 * -----------|FileReader：读取文件的输入字符流
 * -----------|BufferedRead:缓冲输入字符流，提高FileReader读取文件的效率，并扩展FileReader的功能
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
	
	//调用bufferedReader的readLine方法读一行，readLine返回的是String
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
	//自定义readLine()方法
	public static String myReadLine(FileReader fileReader) throws IOException
	{
		StringBuilder stringBuilder =new StringBuilder();
		int content=0;
		while((content=fileReader.read())!=-1)		//返回到是字符的码表int值
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
				stringBuilder.append((char)content);	//要将int值强转为char再添加到StringBuilder中
				}
		}
		fileReader.close();
		return null;
	}
}


