package com.packagingclass;
/*
 * �����������Ͷ����װ��
 * byte Byte
 * short Short
 * int	Integer
 * long	Long
 * boolean	Boolean
 * float Float
 * double	Double
 * char	Character
 * 
 * ������������ת�ַ���
 * 34+""
 * Integer.toString(34)
 * */



//parse    --------->���﷨�����������

public class IntegerDemo {
	public static void main(String[] args)
	{
//		int a=34;
//		String temp=Integer.toString(a);	
		//�������ϵ����ֵ
		System.out.println("int MAX="+Integer.MAX_VALUE);
		//��һ���ַ�ת��������
		int num=Integer.parseInt("123");//���ַ���������Ϊ�з��ŵ�ʮ������ֵ���н���
		long x=Long.parseLong("213235");
		boolean b=Boolean.parseBoolean("true");
		System.out.println("num="+(num+4));
		System.out.println("x="+(x+1));		
		System.out.println(b);
		System.out.println(Integer.toBinaryString(6));		//ʮ����------->������
		System.out.println(Integer.toHexString(60));		//ʮ����------->ʮ������
		//��ָ������ת����ָ������
		int a=Integer.parseInt("110",2);	//2���� Binaray-------> 		ʮ����
		int c=Integer.parseInt("3c",16);	//ʮ������ Hex    ------>		ʮ����
		System.out.println("Binary"+a+"       "+c);
	}

}
