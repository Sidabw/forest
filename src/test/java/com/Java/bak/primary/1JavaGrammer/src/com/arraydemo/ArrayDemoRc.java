package com.arraydemo;

public class ArrayDemo {
	public static void main(String[] args)
	{
		/**
		 * 定义数组的三种方式：
		 * */
		int[] arr1=new int[3]; 
		int[] arr2=new int[]{3,1,4,5};
		int[] arr3={3,4,4,5,6};
			
		int[] arr= {3,3,4,5,6,9};
		int max=getmax(arr);
		System.out.println("max="+max);

		printarr(arr);
	
	}
	//打印数组
	public static void printarr(int[] arr)
	{
		for(int x=0;x<arr.length;x++)
		{
			if(x!=arr.length-1)
		System.out.print("arr["+x+"]="+arr[x]+",");
			else
		System.out.print("arr["+x+"]="+arr[x]);				
		}
	}
	//获取最大值
	public static int getmax(int[] arr)
	{
		int max=arr[0];
				for(int x=1;x<arr.length;x++)
				{
					if(arr[x]>max)
						max=arr[x];
				}
				return max;
	}

}
