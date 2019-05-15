package com.array;

/*
 * 选择排序；冒泡排序
 * 使用亦或运算交换两个变量的值。
 * int a=10,b=12;
 * a=a^b;
 * b=a^b;
 * a=a^b;
 * */
public class Arraysort {
	public static final int IMPORTSTATICDEMO=12;

 public static void selectSort(int[] arr)
	{
	 //数组能够取到的最大角标
		for(int x=0;x<arr.length-1;x++)			//把最小的放在最左边。
		{
			for(int y=x+1;y<arr.length;y++)
			{
				if(arr[x]>arr[y])
					{
				//	int temp=arr[x];
				//	arr[x]=arr[y];
				//	arr[y]=temp;
				 	swap(arr,x,y);				
					}
			}
		}
	}
	
	//  bubble sort：： 冒泡排序
	public static void bubbleSort(int[] arr)	//把最大的放在最右边
	{
		for(int x=0;x<arr.length-1;x++)
		{
			for(int y=0;y<arr.length-x-1;y++)
			{
				if(arr[y]>arr[y+1])
				{
					swap(arr,y,y+1);            
				}
			}
		}
	}
	public static void printArray(int[] arr)
	{
		System.out.print("[");
		for(int x=0;x<arr.length;x++)
		{
			if(x!=arr.length-1)
				System.out.print(arr[x]+",");
			else
				System.out.print(arr[x]+"]");
		}
	}
	public static void swap(int[] arr,int a,int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args)
	{
		int arr[]={2,4,7,3,6};
	//	printArray(arr);             //  排序前
		selectSort(arr);
	//	bubbleSort(arr);
		printArray(arr);			//排序后
	}
}
