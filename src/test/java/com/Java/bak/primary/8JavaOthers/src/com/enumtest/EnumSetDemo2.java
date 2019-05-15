package com.enumtest;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetDemo2 {
	public static void main(String[] args)
	{ 
		//����1��FonConstant���͵Ŀյ�EnumSet
		EnumSet<FonConstant> enumSet=EnumSet.noneOf(FonConstant.class);
		enumSet.add(FonConstant.Bold);
		enumSet.add(FonConstant.Hello);
		
		showEnumSet(enumSet);
	}
	public static void showEnumSet(EnumSet<FonConstant> enumSet)
	{
		for(Iterator<FonConstant> iterator=enumSet.iterator();iterator.hasNext();)
		{
			System.out.println(iterator.next());
		}
	}
}
