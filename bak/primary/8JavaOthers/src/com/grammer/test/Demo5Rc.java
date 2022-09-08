package com.grammer.test;
public class Demo5 {
	public static void main(String[] args) {
		String str="1sadg3";
		char[] ch=str.toCharArray();
		System.out.println(ch[0]);
		//||(ch[ch.length-1]>=48&&ch[ch.length-1]<=57))
		if(ch[0]>=48&&ch[0]<=57){
			System.out.println("该字符串是已数字开头");
		}
		if(ch[ch.length-1]>=48&&ch[ch.length-1]<=57){
			System.out.println("该字符串是已数字结尾");
		}
	}
}
