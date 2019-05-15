package com.packagingclass;

/*
 * StringBuffer	���ַ�������
 * ��һ������
 * 1.���ȿɱ仯
 * 2.����ͬʱ���������������
 * 3.���ջ�ͨ��toString��������ַ���
 * 
 * StringBuilder��StringBuffer������ͬ�����ǲ���֤ͬ�������౻������� StringBuffer ��һ�������滻��
 * �����ַ����������������߳�ʹ�õ�ʱ������������ձ飩��������ܣ��������Ȳ��ø��࣬��Ϊ�ڴ����ʵ���У����� StringBuffer Ҫ�졣 

 * 
 * C create  D delete  U update   R read
 * 1��
 * 2ɾ
 * 3��
 * 4��
 * 
 * 4�� ��
 * 	char charAt(int index)
 *	int  indexOf(String str)
 *	int  lastIndexOf(String str)
 *  int  length()
 *  String  substring(int start,int end)
 *  
 *  5.��ת
 *  StringBuffer  reverse����
 * 
 * 6.����������ָ�����ݴ洢��ָ�������ָ��λ����
 * void getChars(int scrBegin,int scrEnd,char[] chs,int dstBegin)
 * 
 * JDK1.5֮�������StringBuffer
 * StringBuffer ���߳�ͬ��
 * StringBuilder �̲߳�ͬ��    �����ڵ��߳�
 * */

public class StringBufferDemo {
	public static void main(String[] args)
	{
//		method_update();
		method_del();
//		method_add();
	}
	public static void method_update()						//��
	{
		StringBuffer s=new StringBuffer("sjlasdgn");//Դ�����StringBuffer�ĸ���AbstractStringBuffer�����ڹ��췽��������1��16���ַ�+str.length()���ַ����顣
		s.replace(1, 3, "java");//��ͷ����β
		s.setCharAt(2, 'o');
		System.out.println(s.toString()	);
	}
	public static void method_add()							//�洢
	{
		StringBuffer sb=new StringBuffer();					
		sb.append("abc").append(true).append(23);			//StringBuffer �洢   ��ָ��������ӵ��������ݵ� ��β��
		System.out.println(sb.toString());
		sb.insert(1, "QQ");									//StringBuffer ����   ���뵽indexλ��
		System.out.println(sb);
	}
	public static void method_del()							//ɾ��
	{
		StringBuffer s=new StringBuffer("sjlasdgn");
		s.delete(1, 3);
		System.out.println(s);//ɾ��1��3����ͷ����β
		s.deleteCharAt(0);
		System.out.println(s);//ɾ��0
		//���������
		s.delete(0, s.length());
		System.out.println(s);
	}

}
