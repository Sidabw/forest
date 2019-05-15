package com.array;

public class ArrayTest3 {
	public static void main(String[] args)
	{
		toHex(60);
		toBin(6);
	}
	/*
	 * 查表法：十进制转换十六进制
	 * */
/*	public static void toHex(int num)
	{
		char[] chs={'0','1','2','3',
				 '4','5','6','7',
				 '8','9','A','B',
				 'C','D','E','F'};
		char[] arr=new char[8];
		int pos=arr.length;
		while(num!=0)
		{
			int temp=num&15;
			arr[--pos]=chs[temp];
			num=num>>>4;
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]+",");
		}
	}
	public static void toBin(int num)
	{
		char[] chs={'0','1'};
		//定义一个临时储存器
		char[] arr= new char[32];
		//定义一个操作数组的指针
		int pos=arr.length;
		while(num!=0)
		{
			int temp=num&1;
			arr[--pos]=chs[temp];
			num=num>>>1;			
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
	}*/
	public static void trans(int num,int base,int offset)
	{
		char[] chs={'0','1','2','3',
				 '4','5','6','7',
				 '8','9','A','B',
				 'C','D','E','F'};
		char[] arr=new char[8];
		int pos=arr.length;
		while(num!=0)
		{
			int temp=num&base;
			arr[--pos]=chs[temp];
			num=num>>>offset;
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
	}
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	public static void toOct(int num)
	{
		trans(num,7,3);
	}
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
}
