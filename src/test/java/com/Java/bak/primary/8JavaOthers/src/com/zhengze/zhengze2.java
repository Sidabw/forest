package com.zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze2 {
	public static void main(String[] args) {
		//�ֻ���У��
		String phoneNum="15652526191";
		System.out.println(phoneNum.matches("1[358]\\d{9}"));//��1���ַ���1����2���ַ���3��5��8�е�1����֮������[0-9]����9��
		
		//spilDemo("zhangsan.wu.li");
		//replaceAll("zhangggsannnnwuuuli");
		//getDemo();
		s();
		
	}
	//�ָ����
	public static void spilDemo(String demo)
	{
		String[] spilDemo=demo.split("\\.");
		for(String d:spilDemo)
		{
			System.out.println(d);
		}
		
	}
	//ȥ��   �滻
	public static void replaceAll(String demo)
	{
		String d1=demo.replaceAll("(.)\\1+","$1");
		System.out.println(d1);
		
		String phoneNum="15652526191";
		String rpn=phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		System.out.println(rpn);
	}
	
	
			//	��ȡ	��ƥ���������ݻ�ȡ����
			//	ʹ��������ʽ�еĶ��� pattern
			//	ʹ�ò��� ��1���Ƚ�������ʽ����ɶ���
			//			 2��ͨ��pattern�����matches������ȡMatchesƥ��������
			//			 3��ͨ��ƥ��������ķ�������������ʽ�������ַ������Ա��ڲ���
	public static void getDemo()
	{
		String str ="ni hao wang wu zi ni zai gan shen me";
		String regex ="\\b[a-z]{3}\\b";									// \\b�÷�
		Pattern p= Pattern.compile(regex);//��������������ʽ���뵽ģʽ�С�
		Matcher m=p.matcher(str);//����ƥ������������ģʽ��ƥ������ 
		while(m.find()){	//boolean find() ���Բ������ģʽƥ����������е���һ�������С�
			System.out.println(m.group(0));// String group()   ��������ǰƥ�������ƥ������������С� 
		}	
		//System.out.println(m.group(1));//������������ʽ�Ϸ���ʱ�ſ��á�regex="(group1)(group2)(group3)" String group(int group)   ��������ǰ��ƥ���ڼ���������������У�����Ϊ�գ��������δ��ƥ������Ĳ��֣��򷵻� null
	}
	public static void s(){
		String str = "aoz";
		String regex ="ao?z";
		boolean b=str.matches(regex);
		System.out.println(str+":"+b);
	}
}
