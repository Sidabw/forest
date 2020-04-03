package com.zhengze;
/*
 *\\d 数字：[0-9]
 * */
public class Zhengze {
	public static void main(String[] args) {
		String str="zhang54321wu";
		String str1=str.replaceAll("\\d", "-");	//将所有数字（\\d）替换成-
		System.out.println(str1);
		System.out.println("a".matches("."));	//"."代表任意字符
		System.out.println("a".matches("a*"));	//* 代表出现0此或者多次
		System.out.println("abcc".matches("a?"));	//? 代表出现1次或者一次都没有	false	字符串第1个字符匹配，但是后面不匹配，所以整体不匹配
		System.out.println("bbbbb".matches("b+"));	//+ 代表出现1次或者多次。		true
		System.out.println("12234578999322".matches("\\d{3,100}"));	//数字出现3，100次
		System.out.println("192.168.2.234".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//用 \\.作为分隔
		System.out.println("192z168z2z234".matches("\\d{1,3}z\\d{1,3}z\\d{1,3}z\\d{1,3}")); //z在正则表达式里没有特殊含义，所以不需要转义
		System.out.println("192".matches("[0-2][0-9][1-2]"));//中括号代表1个字符
		System.out.println("a".matches("[abc]"));
		System.out.println("ab".matches("[abcv]"));//[] 匹配的是1个字符
		System.out.println("a".matches("[a-z[A-Z]]"));
		System.out.println("a".matches("[a-z]|[A-Z]"));	//与上一行相同都是并集
		System.out.println("a".matches("[a-z]&[A-Z]"));	//交集	
		System.out.println("a_8".matches("\\w{3}"));	//\\w 表示单词字符：[a-zA-Z_0-9] ，（有下划线），出现3次
		
		System.out.println("hello world".matches("^h.*"));//以h开头，后边是任意字符出现0次或者多次
		System.out.println("hello world".matches("^h"));//所有字符必须有匹配的。--->false
		System.out.println("hello world".matches(".*ld$"));//$--->行的结尾
		System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*"));//  o\\b： 以o为单词边界
		
		
		System.out.println("\r\f\n".matches("^[\\s&&[^\\n]]*\\n$"));//以\\s与非\\n的交集为开头，此字符出现0次或者多次，最后以\n结尾
		System.out.println("aaa 9999c".matches(".*\\d{4}."));
		System.out.println("sdfa 9939".matches(".*a [\\d]{4}"));
		
		
	}
}
