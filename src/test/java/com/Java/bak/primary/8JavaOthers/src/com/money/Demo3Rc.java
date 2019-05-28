package com.money;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 结合NumberFormat使用
 * */
public class Demo3 {
	public static void main(String[] args){
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat persent = NumberFormat.getPercentInstance();
		persent.setMaximumFractionDigits(3);//本分比小数点后三位
		
		BigDecimal a = new BigDecimal("15000.89");
		BigDecimal b = new BigDecimal("0.008");
		BigDecimal c = a.multiply(b);
		
		System.out.println("贷款金额：\t"+currency.format(a));// \t 1个tab
		System.out.println("利率"+persent.format(b));
		System.out.println("利息"+currency.format(c));
		
		//比较大小
		BigDecimal aBigDecimal = new BigDecimal("12");
		BigDecimal bBigDecimal = new BigDecimal("11");
		BigDecimal cBigDecimal = new BigDecimal("12");
		int result1 = aBigDecimal.compareTo(bBigDecimal);//大于 返回1
		int result2 = aBigDecimal.compareTo(cBigDecimal);//等于返回0
		int result3 = bBigDecimal.compareTo(aBigDecimal);//小于返回-1
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
}
