package com.array;

import java.util.Arrays;

public class ArraysTool {
	public static void main(String[] args)
	{
		int[] arr=new int[]{2,3,5,1,8,1,4};
		//����ָ��������ַ��������ʽ�����ַ��������ʽ�������Ԫ�ع��ɡ�
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		for(int a:arr)
		{
			System.out.println(a);
		}
		//Arrays�еĶ��ַ����ң����ô˷���ǰ����ȷ��������������ġ�
		int a=Arrays.binarySearch(arr, 4);
		System.out.println(a);
	}
}
