package com.string1;
public class StringDemo 
{
	public static void method_7()
	{
		String s="	Hello Java	";
		sop(s.toLowerCase());		//�ַ���ת����Сд
		sop(s.toUpperCase());		//�ַ���ת���ɴ�д
		sop(s.trim());				//ȥ���ַ�����ͷ�ո�
		
		String s1="abc";
		String s2="aaa";
		sop(s1.compareTo(s2));		//�����ַ���������Ȼ˳��Ƚ�,�Ƚϵ��Ǹ��ַ���Unicodeֵ��s1>s2ʱ����һ����������1��
	}
	public static void method_sub()	//��ȡ�Ӵ�
	{
		String s="abcdef";
		sop(s.substring(2));		//��ͷ��β
		sop(s.substring(2, 4));     //����ͷ������β  			s.substring(0,s.length());
	}
	public static void method_split()		//�и�
	{
		String s="zhangsan,liwu,wanger";
		String[] arr=s.split(",");	//���յ���һ���ַ�������
		for(int x=0;x<arr.length;x++)
		{
			sop(arr[x]);
		}
	}
	public static void method_replace()		//�滻
	{
		String s="hello java";
		String s1=s.replace("a", "n");  		// �ַ���һ�����岻�ɸı�,replace ����a--->n
		String s2=s.replace("java", "wrold");
		sop(s);
		sop(s1);
		sop(s2);
	}
	public static void method_trans()		//ת��
	{
		char[] arr={'a','b','c','d','e','f','g','h',};
		String s=String.copyValueOf(arr,1,4);			//copyValue(char[])  ���Ǿ�̬���� ,��ͷ��β
		String s1=new String(arr,1,3);	//String���캯�������ַ�����ת�����ַ������ӽǱ�Ϊ1���ַ���ʼ������3���ַ���
		String s2="kkjlasdfm";
		char[] chs=s2.toCharArray();	//���ַ���ת�����ַ�����
		for(int x=0;x<chs.length;x++)
		{
			sop(chs[x]);
		}
		sop("s="+s);
		sop(s1);
		/*
		 * ���ֽ�����ת�����ַ�����String(byte[])      String(byte[],offset,count)
		 * ���ַ���ת�����ֽ����飺byte[] getBytes[]              ���⣺ �ַ������ֽ�������ת���������ǿ���ָ��������
		 * ��������������ת�����ַ�����static String valueOf(int);   static String valueOf(double);��
		 * 
		 * */
	}
	public static void method_is()
	{
		String str="ArrayDemo.java";
		sop(str.endsWith(".java"));//�ж�str�ַ����Ƿ�����.java��β                                  boolean��
 		sop(str.startsWith("Array"));//�ж�str�ַ����Ƿ���ArrayΪ��                               boolean��
		sop(str.contains("Demo"));//�ж�str�ַ������Ƿ����Demo				 boolean��
		sop(str.equals("Array"));// �ж��ַ��������Ƿ���ͬ
		sop(str.equalsIgnoreCase("arraydemo.java"));//�ж��ַ��������Ƿ���ͬ�����Դ�Сд
	}
	public static void method_get()
	{
		String str="absedag";
		sop(str.length());
		sop(str.charAt(4));//�Ǳ�Ϊ4���ַ���
//		sop(str.charAt(40));
		sop(str.indexOf('a',6));   //�ӽǱ�Ϊ6���ַ���ʼ���ң������ڴ�ӡ -1
		sop(str.lastIndexOf('a'));  //����������
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		
//		method_7();
//		method_sub();
//		method_split();
//		method_replace();
//		method_trans();
		method_get();
//		method_is();
//		
//		String s1="abc";
//		String s2=new String("abc");
//		String s3="abc";
		//s1��һ������
		//s2����������
//		System.out.println(s1==s2);
//		System.out.println(s1==s3);
//		System.out.println(s1.equals(s2));//String �ิд��object���е�equals�������÷��������ж��ַ��������Ƿ���ͬ��
	}

}
