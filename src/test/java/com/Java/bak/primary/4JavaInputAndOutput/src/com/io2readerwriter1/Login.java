package com.io2readerwriter1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * System.in: �ֶ�in:public static final InputStream in
 * 
 * Scanner���췽���� Scanner(InputStream source)
 * 			.next()���������Ҳ��������Դ�ɨ��������һ���������
 * 
 * */
public class Login {
	static Scanner scanner=new Scanner(System.in);	
	public static void main(String[] args) throws IOException {
		while(true)
		{
			System.out.println("��ѡ���ܣ�A��ע�ᣩ	B����¼)");
			String option=scanner.next();	//���Ҳ��������Դ�ɨ��������һ���������
			if("a".equalsIgnoreCase(option))
			{
				//ѡ����ע��
				reg();
				//break;
			}
			else if("b".equalsIgnoreCase(option))
			{
				login();
				//break;
			}
			else {
				System.out.println("������������������������");
			}
		}
	}
	public static void reg() throws IOException
	{
		System.out.println("�����������û�����");
		String userName=scanner.next();
		System.out.println("�������������룺");
		String password=scanner.next();
		File file =new File("D:\\a.txt");
		FileWriter fileWriter=new FileWriter(file,true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		bufferedWriter.write(userName+" "+password);
		bufferedWriter.newLine();//��Ҫ���У���Ȼ�´ζ��ļ���ʱ��Ͳ�����readLine������
		bufferedWriter.close();
	}
	public static void login() throws IOException
	{
		System.out.println("�����������û�����");
		String userName=scanner.next();
		System.out.println("�������������룺");
		String password=scanner.next();
		String inof=userName+" "+password;
		FileReader fileReader =new FileReader("D:\\a.txt");
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String line=null;
		boolean isLogin=false;
		while((line=bufferedReader.readLine())!=null)
		{
			if(inof.equals(line)){
				isLogin=true;
			}
		}
		if(isLogin)
		{
			System.out.println("��ӭ"+userName+"��¼�ɹ�");
		}
		else {
			System.out.println("�����ڸ��û���Ϣ");
		}
		
	}
}
