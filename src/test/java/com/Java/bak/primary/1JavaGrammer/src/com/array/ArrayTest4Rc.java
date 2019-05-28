package com.array;

public class ArrayTest4 {
	public static void main(String[] args)
	{
		//int newArr[]=method1();
		int[] arr={2,4,1,9,3};
		System.out.println(getMax(arr));
		//printArray(newArr);
		
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
	//将原来的数组的内容中的0删除掉，生成新的数组
	public static int[] method1()
	{
		int arr[]={1,2,3,0,1,2,11};
		System.out.println(arr);	//[I@d0da1d8
		int b=0;
		for(int i=0;i<arr.length;i++,b++)
		{
			if(arr[i]==0)
			{
				b--;
			}
		}
		int newArr[]=new int[b];
		for(int i=0,a=i;i<arr.length;i++,a++)
		{
			if(arr[i]!=0)
			{
				newArr[a]=arr[i];
			}
			else
			{
				a--;
			}
		}
		return newArr;
	}
	public static int getMax(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		return arr[arr.length-1];
	}
}
