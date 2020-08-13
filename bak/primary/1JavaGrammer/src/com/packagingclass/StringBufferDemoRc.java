package com.packagingclass;

/*
 * StringBuffer	是字符缓冲区
 * 是一个容器
 * 1.长度可变化
 * 2.可以同时操作多个数据类型
 * 3.最终会通过toString方法变成字符串
 * 
 * StringBuilder与StringBuffer大致相同，但是不保证同步。该类被设计用作 StringBuffer 的一个简易替换，
 * 用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。 

 * 
 * C create  D delete  U update   R read
 * 1増
 * 2删
 * 3改
 * 4查
 * 
 * 4。 查
 * 	char charAt(int index)
 *	int  indexOf(String str)
 *	int  lastIndexOf(String str)
 *  int  length()
 *  String  substring(int start,int end)
 *  
 *  5.反转
 *  StringBuffer  reverse（）
 * 
 * 6.将缓冲区的指定数据存储到指定数组的指定位置中
 * void getChars(int scrBegin,int scrEnd,char[] chs,int dstBegin)
 * 
 * JDK1.5之后出现了StringBuffer
 * StringBuffer 是线程同步
 * StringBuilder 线程不同步    多用于单线程
 * */

public class StringBufferDemo {
	public static void main(String[] args)
	{
//		method_update();
		method_del();
//		method_add();
	}
	public static void method_update()						//改
	{
		StringBuffer s=new StringBuffer("sjlasdgn");//源码跟到StringBuffer的父类AbstractStringBuffer，并在构造方法中生成1个16个字符+str.length()的字符数组。
		s.replace(1, 3, "java");//包头不包尾
		s.setCharAt(2, 'o');
		System.out.println(s.toString()	);
	}
	public static void method_add()							//存储
	{
		StringBuffer sb=new StringBuffer();					
		sb.append("abc").append(true).append(23);			//StringBuffer 存储   将指定数据添加到已有数据得 结尾处
		System.out.println(sb.toString());
		sb.insert(1, "QQ");									//StringBuffer 插入   插入到index位置
		System.out.println(sb);
	}
	public static void method_del()							//删除
	{
		StringBuffer s=new StringBuffer("sjlasdgn");
		s.delete(1, 3);
		System.out.println(s);//删除1到3，包头不包尾
		s.deleteCharAt(0);
		System.out.println(s);//删除0
		//清除缓冲区
		s.delete(0, s.length());
		System.out.println(s);
	}

}
