package com.day01;

import java.util.Scanner;
/**
 * if/Scanner ��ϰ
 * */
public class Demo1 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("���ĳɼ��ǣ�");
		int score=sc.nextInt();
		if(score>=90&&score<=100){
			System.out.println("����");
		}
		else if(score>=70 && score<90)
		{
			System.out.println("����");
		}
		else if(score>=60&&score<70)
		{
			System.out.println("һ��");
		}
		else {
			System.err.println("�ϲ�");
		}
	}
}
