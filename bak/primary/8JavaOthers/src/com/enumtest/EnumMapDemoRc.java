package com.enumtest;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
	public static void main(String[] args)
	{
		Map<Action,String> map =new EnumMap<Action,String>(Action.class);
		map.put(Action.DOWN, "GoDown");
		map.put(Action.LEFT, "GoLeft");
		map.put(Action.RIGHT,"GoRight");
		
		for(Action action:Action.values())
		{
			System.out.println(map.get(action));
		}
	}
	
}

enum Action
{
	UP,DOWN,LEFT,RIGHT;
}