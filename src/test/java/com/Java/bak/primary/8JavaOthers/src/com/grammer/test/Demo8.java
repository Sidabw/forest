package com.grammer.test;
public class Demo8 {
	/*
	 * /*
	 * ����һ����������һ��int�������飬������������ÿһ�����ּ�����ֵĸ���
		���� ��������[1,2,2,2,3,3,4,4,4,4]  
			��ӡ�����
				����1������1��
				����2������3�Ρ�
				
				
		�磺	ԭ���飺		 int[] arr =   {1,2,2,2,3,3,4,4,4,4,22,0,0}  
		 	��¼���ֵ�Ԫ��	 int[] ele =   {1,2,3,4,22,0}
		 	��¼Ԫ�س��ֵĴ���  int[] count = {1,3,2,4, 1,2}
	 */


		public static void main(String[] args) {
			
			int[] arr = {1,2,2,2,3,3,4,4,4,4};
			int[] ele = new int[arr.length];
			ele[0] = arr[0];
			int index = 1;
			int[] count = new int[arr.length];
			count[0] =1;
			for (int i = 1; i < arr.length; i++) {
				int element = arr[i];
				boolean isFind = false;
				for (int j = 0; j <index; j++) {
					if(ele[j] == element){
						isFind = true;
						count[j]++;
					}
				}
				if (!isFind) {
					ele[index] = element;
					count[index] = 1;
					index++;
				}
			}
			for (int i = 0; i < index; i++) {
				
				System.out.println("����"+ele[i]+"������"+count[i]+"��");
			}
		}
	}
