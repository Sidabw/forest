package com.io1file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * �쳣����
 * 
 * */
public class IOExceptionTest {
	public static void main(String[] args) {
		excTest();
		System.out.println("--------+++++++++++++++++++++-------");
		
	}
	public static void excTest()
	{
		File file =new File("");//pathnameΪNullʱ��NullPointerException
		System.out.println("---------------------------------------");
		FileInputStream fileInputStream=null;
		try{
		fileInputStream=new FileInputStream(file);
		System.out.println("-------------------");
		int length=0;
		byte[] buf= new byte[1024];
		while((length=fileInputStream.read(buf))!=-1)
			{
				System.out.println(new String(buf,0,length));
			}
		}
		catch(IOException e)
		{
			System.out.println("��Դ�������");
			throw new RuntimeException(e);
		}
		finally {
			try{
				if(fileInputStream!=null)
					fileInputStream.close();
			}
			catch(IOException exception)
			{
				System.out.println("��Դ�رմ���");
				throw new RuntimeException(exception);
			}
			
		}
	}
}
