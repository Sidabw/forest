package com.enumtest;

public class EnumTest {
	public static void main(String[] args) {
		doOp(OpConstant.SHOOT);
	}
	public static void doOp(OpConstant opconstant)
	{
		switch(opconstant)
		{
		case SHOOT:
			System.out.println("shoot");
			break;
		case TURN_RIGHT:
			System.out.println("trun right");
			break;
		case TURN_LEFT:
			System.out.println("turn left");
			break;
		}
	}
}
enum OpConstant
{
	TURN_RIGHT,TURN_LEFT,SHOOT;
}
