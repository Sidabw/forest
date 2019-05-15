package com.money;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * ���NumberFormatʹ��
 * */
public class Demo3 {
	public static void main(String[] args){
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat persent = NumberFormat.getPercentInstance();
		persent.setMaximumFractionDigits(3);//���ֱ�С�������λ
		
		BigDecimal a = new BigDecimal("15000.89");
		BigDecimal b = new BigDecimal("0.008");
		BigDecimal c = a.multiply(b);
		
		System.out.println("�����\t"+currency.format(a));// \t 1��tab
		System.out.println("����"+persent.format(b));
		System.out.println("��Ϣ"+currency.format(c));
		
		//�Ƚϴ�С
		BigDecimal aBigDecimal = new BigDecimal("12");
		BigDecimal bBigDecimal = new BigDecimal("11");
		BigDecimal cBigDecimal = new BigDecimal("12");
		int result1 = aBigDecimal.compareTo(bBigDecimal);//���� ����1
		int result2 = aBigDecimal.compareTo(cBigDecimal);//���ڷ���0
		int result3 = bBigDecimal.compareTo(aBigDecimal);//С�ڷ���-1
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
}
