package com.day01;
/**
 * ��ӡͼ��
 * */
public class Demo2 {
	public static void main(String[] args)
	{
		//����
		for(int i=0;i<3;i++){
			for(int j=0;j<8;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		//ƽ���ı���
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
		//������
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
