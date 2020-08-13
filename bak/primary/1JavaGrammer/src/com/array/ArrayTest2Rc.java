package com.array;
/*
	 十进制转换二进制
 */
public class ArrayTest2 {
	public static void toBin(int num)
	{
		StringBuffer sb=new StringBuffer();
		while(num>0)
		{
			sb.append(num%2);
			num=num/2;
		}
		System.out.println(sb.reverse());
	}
	/*
	 * 十进制转十六进制(结果是反着的)
	 * */
	public static void toHex(int num)
	{
		for(int x=0;x<8;x++)
		{
		int temp=num&15;
		if(temp>9)
			System.out.print((char)(temp-10+'A'));
		else
			System.out.print(temp);
		
		num=num>>>4;
		}
	}
	public static void toHex_2(int num)
	{
		StringBuffer sb=new StringBuffer();
		for(int x=0;x<8;x++)
		{
			int temp=num&15;
			if(temp>9)
			sb.append((char)(temp-10+'A'));
			else
			sb.append(temp);
			num=num>>>4;
		}
		System.out.print(sb.reverse());
			
		
	}

	
	
	public static void main(String[] args)
	{
		toBin(6);
		toHex(60);
	}
}
