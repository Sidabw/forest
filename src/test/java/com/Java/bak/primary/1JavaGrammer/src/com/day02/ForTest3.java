package com.day02;

import java.util.Scanner;

public class ForTest3 {
	public static void main(String[] args)
	{
		//����1����λ������������ÿλ��+5��Ȼ���ÿλ��ȡģ��Ȼ���һλ�����λ����λ�ã��ڶ�λ�����λ����λ�ã����յó����ܺ����λ����
		Scanner scanner =new Scanner(System.in);
		System.out.println("������һ����λ��������");
		int a=scanner.nextInt();
		int a4=a%10;//���1λ
		int a3=(a/10)%10;//�����ڶ�λ
		int a2=(a/100)%10;//��������λ
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
		
		System.out.println("���ܺ������Ϊ��"+((a1*1000)+(a2*100)+(a3*10)+a4));
		
		
	}
}
