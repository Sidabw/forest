package com.string1;

public class StringTest12 {
	public static void main(String[] args)
	{
		String s="     abn lz      ";
//		sop(s);
//		s=myTrim(s);
//		sop("s="+s);
		sop(reverseString(s));
	}
	public static String reverseString(String s)		//		�ַ�����ת
	{
		//�ַ���������
		char[] chs=s.toCharArray();
		//��ת����
		reverse(chs);
		//���������ַ���
		return new String(chs);
		
	}
	public static void reverse(char[] arr)
	{
		for(int start=0,end=arr.length-1;start<=end;start++,end--)
		{
			swap(arr,start,end);
		}
	}
	public static void swap(char[] arr,int start,int end)
	{
		char temp;
		temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		
	}
	public static String myTrim(String str)			//��ϰһ��     	ȥ���ַ������ߵĿո�
	{
		int start=0;
		int end=str.length()-1;
		while(start<=end&&str.charAt(start)==' ')
			start++;
		while(start<=end && str.charAt(end)==' ')
			end--;
		
		return str.substring(start,end+1);// substring��ͷ����β   ����end+1
		
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}

}
