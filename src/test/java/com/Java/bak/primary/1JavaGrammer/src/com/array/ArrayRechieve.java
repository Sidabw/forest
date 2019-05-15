package com.array;

/**
 * �۰��������Ԫ��
 * */
public class ArrayRechieve {
	public static int getindex(int[] arr,int key)
	{
		for(int y=0;y<arr.length;y++)
		{
			if(arr[y]==key)
				return y;
		}
		return -1;
		
	}
	/*
	 * halfSearch	�۰����	��ֲ���		�������˳��������źõ�
	 * */
	public static int halfSearch(int[] arr,int key)
	{
		int min=0, max=arr.length-1,mid;
		mid=(min+max)>>1;	//�ҵ��м�λ��.mid=(min+max)/2		����2��1�η�
		while(arr[mid]!=key)
		{
			if(key>arr[mid])
				min=mid+1;
			else if(key<arr[mid])
				max=mid-1;
			if(min>max)
				return -1;
			mid=(min+max)>>1;
		}
		return mid;
	}
	public static int halfSearch_2(int[] arr,int key)
	{
		int min=0,max=arr.length-1,mid;
		while(min<max)
		{
			mid=(min+max)>>1;
			if (key>arr[mid])
				min=mid+1;
			else if(key<arr[mid])
				max=mid-1;
			else
				return mid;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int arr[]={2,4,5,7,9 };
	// f	int index=getindex(arr,6);
//		System.out.println("index="+index);
		int index=halfSearch_2(arr,3);
		System.out.println("index="+index);
	}
}
