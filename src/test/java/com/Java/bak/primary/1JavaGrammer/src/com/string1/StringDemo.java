package com.string1;
public class StringDemo 
{
	public static void method_7()
	{
		String s="	Hello Java	";
		sop(s.toLowerCase());		//字符串转换成小写
		sop(s.toUpperCase());		//字符串转换成大写
		sop(s.trim());				//去掉字符串两头空格
		
		String s1="abc";
		String s2="aaa";
		sop(s1.compareTo(s2));		//两个字符串按照自然顺序比较,比较的是各字符的Unicode值，s1>s2时返回一个正整数（1）
	}
	public static void method_sub()	//获取子串
	{
		String s="abcdef";
		sop(s.substring(2));		//包头包尾
		sop(s.substring(2, 4));     //包含头不包含尾  			s.substring(0,s.length());
	}
	public static void method_split()		//切割
	{
		String s="zhangsan,liwu,wanger";
		String[] arr=s.split(",");	//接收的是一个字符串数组
		for(int x=0;x<arr.length;x++)
		{
			sop(arr[x]);
		}
	}
	public static void method_replace()		//替换
	{
		String s="hello java";
		String s1=s.replace("a", "n");  		// 字符串一旦定义不可改变,replace 所有a--->n
		String s2=s.replace("java", "wrold");
		sop(s);
		sop(s1);
		sop(s2);
	}
	public static void method_trans()		//转换
	{
		char[] arr={'a','b','c','d','e','f','g','h',};
		String s=String.copyValueOf(arr,1,4);			//copyValue(char[])  都是静态方法 ,包头包尾
		String s1=new String(arr,1,3);	//String构造函数，将字符数组转换成字符串（从角标为1的字符开始，向右3个字符）
		String s2="kkjlasdfm";
		char[] chs=s2.toCharArray();	//将字符串转换成字符数组
		for(int x=0;x<chs.length;x++)
		{
			sop(chs[x]);
		}
		sop("s="+s);
		sop(s1);
		/*
		 * 将字节数组转换成字符串：String(byte[])      String(byte[],offset,count)
		 * 将字符串转换成字节数组：byte[] getBytes[]              特殊： 字符串和字节数组在转换过程中是可以指定编码表的
		 * 将基本数据类型转换成字符串：static String valueOf(int);   static String valueOf(double);、
		 * 
		 * */
	}
	public static void method_is()
	{
		String str="ArrayDemo.java";
		sop(str.endsWith(".java"));//判断str字符串是否是以.java结尾                                  boolean型
 		sop(str.startsWith("Array"));//判断str字符串是否以Array为首                               boolean型
		sop(str.contains("Demo"));//判断str字符串中是否包含Demo				 boolean型
		sop(str.equals("Array"));// 判断字符串内容是否相同
		sop(str.equalsIgnoreCase("arraydemo.java"));//判断字符串内容是否相同，忽略大小写
	}
	public static void method_get()
	{
		String str="absedag";
		sop(str.length());
		sop(str.charAt(4));//角标为4的字符；
//		sop(str.charAt(40));
		sop(str.indexOf('a',6));   //从角标为6的字符开始查找，不存在打印 -1
		sop(str.lastIndexOf('a'));  //反向索引；
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		
//		method_7();
//		method_sub();
//		method_split();
//		method_replace();
//		method_trans();
		method_get();
//		method_is();
//		
//		String s1="abc";
//		String s2=new String("abc");
//		String s3="abc";
		//s1有一个对象
		//s2有两个对象
//		System.out.println(s1==s2);
//		System.out.println(s1==s3);
//		System.out.println(s1.equals(s2));//String 类复写了object类中的equals方法；该方法用于判断字符串内容是否相同。
	}

}
