package com.enumtest;

public class ShowEnum {
	public static void main(String[] args)
	{
		enumCompareTo(OpConstant.valueOf(args[0]));
	}
	public static void enumCompareTo(OpConstant opConstant)
	{
		System.out.println(opConstant);
		for(OpConstant o:opConstant.values())	//opConstant��ö�����1��ʵ��������values������������ö��ֵ
		{
			System.out.println(opConstant.compareTo(o));
		}
	}
}
