package com.array;

import java.util.Arrays;

public class ArraysTool {
	public static void main(String[] args)
	{
		int[] arr=new int[]{2,3,5,1,8,1,4};
		//返回指定数组的字符串表达形式，该字符串表达形式由数组的元素构成。
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		for(int a:arr)
		{
			System.out.println(a);
		}
		//Arrays中的二分法查找，调用此方法前必须确保该数组是有序的。
		int a=Arrays.binarySearch(arr, 4);
		System.out.println(a);
	}
}
