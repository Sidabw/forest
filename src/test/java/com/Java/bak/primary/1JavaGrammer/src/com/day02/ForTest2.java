package com.day02;

public class ForTest2 {
	public static void main(String[] args)
	{
		//��ӡ1-100�ڵ�����������ֻ�ܱ�1����������������Ϊ������
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
