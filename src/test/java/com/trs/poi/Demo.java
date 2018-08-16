
package com.trs.poi;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class Demo {
	public static void main(String[] args){
		Object o = new Integer(1);
		Integer integer = new Integer(1);
		String s = "1";
		System.out.println(integer.equals(o));
		System.out.println(integer.equals(s));
		System.out.println(Collections.singletonList(new Integer(1)));
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
