package com.grammer.test;
public class Demo8 {
	/*
	 * /*
	 * 定义一个方法传入一个int类型数组，输出这个数组中每一个数字及其出现的个数
		例如 传入数组[1,2,2,2,3,3,4,4,4,4]  
			打印结果：
				数字1出现了1次
				数字2出现了3次…
				
				
		如：	原数组：		 int[] arr =   {1,2,2,2,3,3,4,4,4,4,22,0,0}  
		 	记录出现的元素	 int[] ele =   {1,2,3,4,22,0}
		 	记录元素出现的次数  int[] count = {1,3,2,4, 1,2}
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
				
				System.out.println("数字"+ele[i]+"出现了"+count[i]+"次");
			}
		}
	}
