package com.day02;

public class ForTest2 {
	public static void main(String[] args)
	{
		//打印1-100内的所有素数（只能被1和他本身整除的数为素数）
		for(int i=1;i<=100;i++)
		{
			if(i==1||i==2)
			{
				System.out.println(i);
				continue;
			}
			int c=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					c=j;
					break;
				}
			}
			if(c==0)
			{
				System.out.print(i);
				System.out.println();
			}
		}
	}
}
