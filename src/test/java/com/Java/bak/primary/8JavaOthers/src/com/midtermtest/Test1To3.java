package com.midtermtest;

public class Test1To3 {
	public static void main(String[] args) {
		System.out.println("���");		//Test1
		/*
		 * ��ͨ���ܱ�4�����Ҳ��ܱ�100������Ϊ����.����2004���������,1901�겻�����꣩
		 * �������ܱ�400������������.(��2000��������,1900�겻������)
		 * */
		int x=2000;
		System.out.println(x%4);
		if((x%100)==0)
		{
			if((x%400)==0)
				System.out.println(x+"��������");
			else
				System.out.println(x+"�겻������");
		}
		else if(x%4==0)
			System.out.println(x+"��������");
		else
			System.out.println(x+"�겻������");
		
		
		
		/*
		 * 1!+2!+3!+4!+....+10!	 =  ?
		 * 3!=1*2*3
		 * */
		int b=1;
		int c=0;
		for(int i=1;i<11;i++)
		{
			for(int a=1;a<=i;a++)
			{
				b=b*a;
			}
		c=c+b;
		b=1;
		}
		System.out.println("1!+2!+3!+4!+....+10!Ϊ"+c);
			
	}
}
