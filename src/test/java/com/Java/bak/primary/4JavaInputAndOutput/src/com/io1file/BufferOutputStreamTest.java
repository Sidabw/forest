package com.io1file;

/*
 * -----|OutputStream	��������ֽ����Ļ���
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
		bufferedOutputStream .write("zhangsan".getBytes());//����bufferOutputStream��write�ķ���ֻ�������д�뵽�ڲ�ά���������У�
															//Ҫд��Ӳ���ϱ������flush��close���������ڲ������ֽ������Ѿ���������ʱ��
		bufferedOutputStream.close();
	}

}
