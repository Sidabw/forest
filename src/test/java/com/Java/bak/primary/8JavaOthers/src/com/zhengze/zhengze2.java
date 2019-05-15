package com.zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze2 {
	public static void main(String[] args) {
		//手机号校验
		String phoneNum="15652526191";
		System.out.println(phoneNum.matches("1[358]\\d{9}"));//第1个字符是1，第2个字符是3、5、8中的1个，之后数字[0-9]出现9次
		
		//spilDemo("zhangsan.wu.li");
		//replaceAll("zhangggsannnnwuuuli");
		//getDemo();
		s();
		
	}
	//分割操作
	public static void spilDemo(String demo)
	{
		String[] spilDemo=demo.split("\\.");
		for(String d:spilDemo)
		{
			System.out.println(d);
		}
		
	}
	//去重   替换
	public static void replaceAll(String demo)
	{
		String d1=demo.replaceAll("(.)\\1+","$1");
		System.out.println(d1);
		
		String phoneNum="15652526191";
		String rpn=phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		System.out.println(rpn);
	}
	
	
			//	获取	将匹配规则的内容获取出来
			//	使用正则表达式中的对象 pattern
			//	使用步骤 ：1、先将正则表达式编译成对象
			//			 2、通过pattern对象的matches方法获取Matches匹配器对象。
			//			 3、通过匹配器对象的方法，将正则表达式作用于字符串上以便于操作
	public static void getDemo()
	{
		String str ="ni hao wang wu zi ni zai gan shen me";
		String regex ="\\b[a-z]{3}\\b";									// \\b用法
		Pattern p= Pattern.compile(regex);//将给定的正则表达式编译到模式中。
		Matcher m=p.matcher(str);//创建匹配给定输入与此模式的匹配器。 
		while(m.find()){	//boolean find() 尝试查找与该模式匹配的输入序列的下一个子序列。
			System.out.println(m.group(0));// String group()   返回由以前匹配操作所匹配的输入子序列。 
		}	
		//System.out.println(m.group(1));//必须在正则表达式上分组时才可用。regex="(group1)(group2)(group3)" String group(int group)   返回在以前的匹配期间组所捕获的子序列（可能为空）；如果组未能匹配输入的部分，则返回 null
	}
	public static void s(){
		String str = "aoz";
		String regex ="ao?z";
		boolean b=str.matches(regex);
		System.out.println(str+":"+b);
	}
}
