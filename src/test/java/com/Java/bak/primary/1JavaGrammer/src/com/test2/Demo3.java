package com.test2;

import java.util.ArrayList;

/*
 * �Զ�װ�䣺
 * �Զ����䣺��һ����װ�����ֱ�Ӹ�����Ӧ�Ļ�����������
 * */
public class Demo3 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(5);//�Զ�װ��
		int i=arrayList.get(0);//�Զ�����int i=(Integer)arrayList.get(0);
		System.out.println(i);
	}
}
