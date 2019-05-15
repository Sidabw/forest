package com.money;

import java.math.BigDecimal;
/**
BigDecimal���÷�������

add(BigDecimal)            BigDecimal�����е�ֵ��ӣ�Ȼ�󷵻��������
subtract(BigDecimal)    BigDecimal�����е�ֵ�����Ȼ�󷵻��������
multiply(BigDecimal)    BigDecimal�����е�ֵ��ˣ�Ȼ�󷵻��������
divide(BigDecimal)        BigDecimal�����е�ֵ�����Ȼ�󷵻��������
toString()                         ��BigDecimal�������ֵת�����ַ�����
doubleValue()                 ��BigDecimal�����е�ֵ��˫���������ء�
floatValue()                     ��BigDecimal�����е�ֵ�Ե����������ء�
longValue()                     ��BigDecimal�����е�ֵ�Գ��������ء�
intValue()                       ��BigDecimal�����е�ֵ���������ء�

���Ȳ����ַ�����BigDecimal�Ĺ��췽��
 * */
public class Demo {
	public static void main(String[] args){
		BigDecimal aBigDecimal = new BigDecimal(10.00);
		BigDecimal bBigDecimal = new BigDecimal(9.1);
		//Ӧ�õõ��Ľ���� 0.9 ʵ���ǣ�0.9000000000000003552713678800500929355621337890625
		System.out.println(aBigDecimal.subtract(bBigDecimal));
		//1.ͨ�����þ��������
		System.out.println(aBigDecimal.subtract(bBigDecimal).setScale(2, BigDecimal.ROUND_HALF_UP));
		//2.ͨ���ַ���ʵ�����ķ�ʽ���
		BigDecimal b1 = new BigDecimal("10.00");
		BigDecimal b2 = new BigDecimal("9.1");
		System.out.println(b1.subtract(b2));
		
		//ȡ������	���-9.1
		System.out.println(b2.negate());
	}
}
