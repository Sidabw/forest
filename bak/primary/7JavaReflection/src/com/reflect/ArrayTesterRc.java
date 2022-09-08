package com.reflect;

import java.lang.reflect.Array;

public class ArrayTester {
	public static void main(String[] args) {
		int[] dim=new int[]{3,10,5};
		Object array=Array.newInstance(Integer.TYPE, dim);
		Object arrayObj=Array.get(array, 2);
		arrayObj=Array.get(arrayObj, 5);
		Array.setInt(arrayObj, 2, 100);
		int[][][] arrayCast=(int[][][])array;
		System.out.println(arrayCast[2][5][2]);
		
				
	}
}
