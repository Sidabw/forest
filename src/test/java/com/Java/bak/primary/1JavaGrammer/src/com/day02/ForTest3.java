package com.day02;

import java.util.Scanner;

public class ForTest3 {
	public static void main(String[] args)
	{
		//输入1个四位数的正整数，每位数+5，然后对每位数取模，然后第一位与第四位互换位置，第二位与第三位互换位置，最终得出加密后的四位数：
		Scanner scanner =new Scanner(System.in);
		System.out.println("请输入一个四位正整数：");
		int a=scanner.nextInt();
		int a4=a%10;//最后1位
		int a3=(a/10)%10;//倒数第二位
		int a2=(a/100)%10;//倒数第三位
		int a1=a/1000;
		
		a1+=5;
		a2+=5;
		a3+=5;
		a4+=5;
		
		a1%=10;
		a2%=10;
		a3%=10;
		a4%=10;
		
		a1=a1^a4;
		a4=a1^a4;
		a1=a1^a4;
		
		a2=a2^a3;
		a3=a2^a3;
		a2=a2^a3;
		
		System.out.println("加密后的数据为："+((a1*1000)+(a2*100)+(a3*10)+a4));
		
		
	}
}
