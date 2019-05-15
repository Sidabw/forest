package com.io2readerwriter3;
/*
 * �ֽ���
	  ��������
 * ------|InputStream ���������ֽ����Ļ���	������
 * ---------|FileInputStream ��ȡ�ļ��������ֽ���
 * ---------|FilterInputStream----->BufferedInputStream  ���������ֽ����������ڲ�ά����һ��8kb���ֽ����顣���FileInpuStream��ȡ�ļ���Ч��
 *  										1.�ҵ�Ŀ���ļ� File file= new File();
 *  										2.�������ݵ�����ͨ�� FileOutputStream fileOutputStream=new FileOutputStream(file);
 *  										3.��ȡ�ļ��е�����
 *  										4.�ر���Դ
	 ������� ------|OutputStream		����������ֽ����ĸ���
 * 		    ----------|FileOutputStream 	���ļ�������ݵ�����ֽ���
 * 			----------|FilterOutputStream----->BufferedOutputStream
 * �ַ���=�ֽ���+����
 * 
 * �ַ�����
 * �����ַ�����
 *  
 * ---------|Reader�������ַ����Ļ��࣬��abstract
 * -----------|FileReader����ȡ�ļ��������ַ���
 * -----------|BufferedReader	���������ַ���	���FileReader��Ч�ʣ�--readLine()
 * 
 * 
 * 
 * 
 * 
 *  * ----|Writer	��������ַ����Ļ���   ������
 * 		------|FileWriter ���ļ�������ݵ�����ַ���
 * 		------|BufferedWriter ��������ַ���  ���FileWriter��Ч�ʣ�����չFileWriter�Ĺ��� --newLine() -->\r\n
 * 
 * 
 * 
 * ��������룺
 * 		������������ʱ��ָ��unicode,����utf-16,
 * */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		String string="a�й�";
		byte[] buf=string.getBytes("utf-8");		//����-----ָ�������ʱ��byte[]=string.getBytes("gbk")
		System.out.println(Arrays.toString(buf));
		String str=new String(buf,"utf-8");	//����ָ�����������ֽ�����
		System.out.println(str);
		
		
		
		
	}
}
