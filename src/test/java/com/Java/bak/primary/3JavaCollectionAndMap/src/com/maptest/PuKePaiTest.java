package com.maptest;
//List������ظ���Set���򲻿��ظ�

import java.util.LinkedList;
import java.util.ListIterator;
public class PuKePaiTest {
	public static void main(String[] args) {
		
		LinkedList<PuKePai> l=new LinkedList<PuKePai>();
		String b="����";
		int c=1;
		for(int a=1;a<5;a++)
		{
			for(int i=1;i<14;i++)
			{
				l.add(new PuKePai(b, i));
			}
			c=c+1;
			switch(c)
			{
			case 1:
				b="����";
				break;
			case 2:
				b="����";
				break;
			case 3:
				b="÷��";
				break;
			case 4:
				b="��Ƭ";
				break;
			}
		}
//		xipai(l);
//		System.out.println(l);	
		LinkedList<PuKePai> xipai1=xipai(l);
		ListIterator<PuKePai> it=xipai1.listIterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println(xipai1.size());
		
		}
	public static LinkedList<PuKePai> xipai(LinkedList<PuKePai> ll)
	{
		
		LinkedList<PuKePai> xipai1=new LinkedList<PuKePai>();
		LinkedList<Integer> quchong=new LinkedList<Integer>();
		while(xipai1.size()<ll.size())
		{
			int i=Math.round((float)Math.random()*60);
			for(;i>51;)
			{
				 i=Math.round((float)Math.random()*60);
			}
			if(!quchong.contains(i))
				xipai1.add(ll.get(i));
			quchong.add(i);		
//			System.out.println(i);
		}
		return xipai1;
	}
	
}

class PuKePai //implements Comparable
{
	private String huase;
	private int dian;
	public PuKePai(String huase,int dian) {
		// TODO Auto-generated constructor stub
	this.dian=dian;
	this.huase=huase;
	}
	public String toString()
	{
		return this.huase+"    "+this.dian;
	}
//	public int compareTo(Object object)
//	{
//		if(!(object instanceof PuKePai))
//			return -1;
//		PuKePai pai=(PuKePai)object;
//		if(this.huase.equals(pai.huase))
//			return 
//	}
}
