package com.array;

/*
 * ѡ������ð������
 * ʹ��������㽻������������ֵ��
 * int a=10,b=12;
 * a=a^b;
 * b=a^b;
 * a=a^b;
 * */
public class Arraysort {
	public static final int IMPORTSTATICDEMO=12;

 public static void selectSort(int[] arr)
	{
	 //�����ܹ�ȡ�������Ǳ�
		for(int x=0;x<arr.length-1;x++)			//����С�ķ�������ߡ�
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
	
	//  bubble sort���� ð������
	public static void bubbleSort(int[] arr)	//�����ķ������ұ�
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
	//	printArray(arr);             //  ����ǰ
		selectSort(arr);
	//	bubbleSort(arr);
		printArray(arr);			//�����
	}
}
