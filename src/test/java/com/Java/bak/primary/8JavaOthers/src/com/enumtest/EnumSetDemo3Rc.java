package com.enumtest;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class EnumSetDemo3 {
	public static void main(String[] args)
	{
		List<FonConstant> list =new ArrayList<FonConstant>();
		list.add(FonConstant.Bold);
		list.add(FonConstant.Plain);
		list.add(FonConstant.Hello);
		//将数组中的元素放置到EnumSet中来
		showEnumSet(EnumSet.copyOf(list));
		
	}
	public static void showEnumSet(EnumSet<FonConstant> enumSet)
	{
		for(Iterator<FonConstant> iterator=enumSet.iterator();iterator.hasNext();)
		{
			System.out.println(iterator.next());
		}
	}
}
