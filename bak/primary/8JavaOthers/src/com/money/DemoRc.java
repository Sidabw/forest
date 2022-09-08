package com.money;

import java.math.BigDecimal;
/**
BigDecimal常用方法描述

add(BigDecimal)            BigDecimal对象中的值相加，然后返回这个对象。
subtract(BigDecimal)    BigDecimal对象中的值相减，然后返回这个对象。
multiply(BigDecimal)    BigDecimal对象中的值相乘，然后返回这个对象。
divide(BigDecimal)        BigDecimal对象中的值相除，然后返回这个对象。
toString()                         将BigDecimal对象的数值转换成字符串。
doubleValue()                 将BigDecimal对象中的值以双精度数返回。
floatValue()                     将BigDecimal对象中的值以单精度数返回。
longValue()                     将BigDecimal对象中的值以长整数返回。
intValue()                       将BigDecimal对象中的值以整数返回。

优先采用字符串的BigDecimal的构造方法
 * */
public class Demo {
	public static void main(String[] args){
		BigDecimal aBigDecimal = new BigDecimal(10.00);
		BigDecimal bBigDecimal = new BigDecimal(9.1);
		//应该得到的结果是 0.9 实际是：0.9000000000000003552713678800500929355621337890625
		System.out.println(aBigDecimal.subtract(bBigDecimal));
		//1.通过设置精度来解决
		System.out.println(aBigDecimal.subtract(bBigDecimal).setScale(2, BigDecimal.ROUND_HALF_UP));
		//2.通过字符串实例化的方式解决
		BigDecimal b1 = new BigDecimal("10.00");
		BigDecimal b2 = new BigDecimal("9.1");
		System.out.println(b1.subtract(b2));
		
		//取反操作	输出-9.1
		System.out.println(b2.negate());
	}
}
