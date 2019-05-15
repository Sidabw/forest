package com.io1file;

/*
 * -----|OutputStream	所有输出字节流的基类
 * --------|FileOutputStream
 * --------|BufferOutputStream
 * 
 * */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutputStreamTest {
	public static void main(String[] args)  throws IOException{
		writeTest();
	}
	public static void writeTest() throws IOException
	{
		File file =new File("D:\\a.txt");
		FileOutputStream fileOutputStream =new FileOutputStream(file,true);
		BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(fileOutputStream );
		bufferedOutputStream .write("zhangsan".getBytes());//调用bufferOutputStream的write的方法只会把数据写入到内部维护的数组中，
															//要写到硬盘上必须调用flush、close方法或者内部缓冲字节数组已经填满数据时。
		bufferedOutputStream.close();
	}

}
