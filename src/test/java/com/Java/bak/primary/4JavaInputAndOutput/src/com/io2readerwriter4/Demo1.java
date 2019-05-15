package com.io2readerwriter4;
/*
 * FileWriter使用注意：
 * 		1.FileWriter内部维护了一个1024的数组，会先把数据给1024，不关、不刷新或者填不满数据写不到文档里
 * 
 * 
 * 什么时候使用字符流，什么时候使用字节流？
 * 
 * 		字符流应用场景：读写字符数据时，汉字、英文等，如word
 * 		字节流应用场景：不需要转换为字符时，如图片、视频、mp3等
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
		String data="dajih好";
		fileWriter.write(data);//	不需要再data.getByte();,fileWriter里有自解码的write(String str)方法
		//fileWriter.flush();
		fileWriter.close();
	}
	
	//使用FileReader、FileWriter拷贝图片
	//FileReader默认使用的gbk编码表（双字节编码，汉字，图形符号），码表中65536个玛格中有些数字是没有对应的字符的。这时会返回一个未知字符，未知字符占1个字节，所以数据损失，文件变小。
	//所以图片的拷贝需要使用字节流
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
