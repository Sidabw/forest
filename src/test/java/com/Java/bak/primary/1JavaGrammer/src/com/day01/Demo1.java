package com.day01;

import java.util.Scanner;
/**
 * if/Scanner 练习
 * */
public class Demo1 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("您的成绩是：");
		int score=sc.nextInt();
		if(score>=90&&score<=100){
			System.out.println("优秀");
		}
		else if(score>=70 && score<90)
		{
			System.out.println("良好");
		}
		else if(score>=60&&score<70)
		{
			System.out.println("一般");
		}
		else {
			System.err.println("较差");
		}
	}
}
