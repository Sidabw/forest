package com.day01;
/**
 * 打印图形
 * */
public class Demo2 {
	public static void main(String[] args)
	{
		//矩形
		for(int i=0;i<3;i++){
			for(int j=0;j<8;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		//平行四边形
		int a=5;
		for(int i=0;i<4;i++){
			for(int j=0;j<a;j++)
			{
				System.out.print(" ");
			}
			for(int b=0;b<8;b++)
			{
				System.out.print("*");
			}
			a--;
			System.out.println();
			
		}
		System.out.println("------------------");
		//三角形
		a=5;
		int b=1;
		for(int i=0;i<5;i++)
		{
			for(int c=0;c<a;c++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<b;j++)
			{
				System.out.print("*");
			}
			b+=2;
			a--;
			System.out.println();
		}
		
	}
}
