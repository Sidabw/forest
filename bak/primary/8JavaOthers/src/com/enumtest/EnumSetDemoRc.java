package com.enumtest;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetDemo {
	public static void main(String[] args)
	{
		EnumSet<FonConstant> enumSet=EnumSet.of(FonConstant.Plain, FonConstant.Bold);
		showEnumSet(enumSet);
		System.out.println(EnumSet.complementOf(enumSet));
	}
	public static void showEnumSet(EnumSet<FonConstant> enumSet)
	{
		for(Iterator<FonConstant> iterator=enumSet.iterator();iterator.hasNext();)
		{
			System.out.println(iterator.next());
		}
	}
}
enum FonConstant
{
	Plain,Bold,Italilc,Hello;
}
