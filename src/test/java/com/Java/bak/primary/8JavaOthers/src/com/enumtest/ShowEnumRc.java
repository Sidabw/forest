package com.enumtest;

public class ShowEnum {
	public static void main(String[] args)
	{
		enumCompareTo(OpConstant.valueOf(args[0]));
	}
	public static void enumCompareTo(OpConstant opConstant)
	{
		System.out.println(opConstant);
		for(OpConstant o:opConstant.values())	//opConstant是枚举类的1个实例，调用values方法返回所有枚举值
		{
			System.out.println(opConstant.compareTo(o));
		}
	}
}
