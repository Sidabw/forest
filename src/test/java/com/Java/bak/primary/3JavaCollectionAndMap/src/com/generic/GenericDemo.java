package com.generic;
import java.util.*;
/*
 * Generic(����)��JDK1.5�����ԣ����ڽ����ȫ���⣬��һ����ȫ���ơ�
 * ֮ǰ����ʱ��ClassCastExceptionת�Ƶ��˱���ʱ�ڣ��������Ա������⡣
 * */
public class GenericDemo {
	public static void main(String[] args)
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		Iterator<String> it=al.iterator();
		while(it.hasNext())
		{
			String s=it.next();			//����ǿת
			System.out.println(s+"....."+s.length());
		}
	}
}
