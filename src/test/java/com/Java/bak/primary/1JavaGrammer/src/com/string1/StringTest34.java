package com.string1;

public class StringTest34
{
	public static void main(String[] args)
	{
		String s="ackkhhlkkbghkkuuenkkdx";
		String s1="dfkkbghkhfc";
		String s2="zghkhf";
		//�ж��ַ���s��һ���ж���"kk"
		System.out.println(getSubCount(s,"kk"));
		System.out.println(s.split("kk").length);//������ʹ�ã������ͷ��KK ���г����ַ�����ɽ����׼ȷ
		System.out.print(getString(s1,s2));
	}
	public static int getSubCount(String s,String key)
	{
		int count=0;
		int index=0;
		while((index=s.indexOf(key))!=-1)			// �����ԣ� while((index=s.indexOf(key,index))!=-1)
		{
			System.out.println(s);					//index=index+key.length();
			s=s.substring(index+key.length());		//subString(int beginIndex)
			count++;
		}
		return count;
	}
	public static String getString(String s1,String s2)
	{
		for(int x=0;x<s2.length();x++)
		{
			for(int y=0,z=s2.length()-x;z!=s2.length()+1;y++,z++)
			{
				String temp=s2.substring(y,z);
				if(s1.contains(temp))
					return temp;
			}
		}	
		return " ";
	}
}
