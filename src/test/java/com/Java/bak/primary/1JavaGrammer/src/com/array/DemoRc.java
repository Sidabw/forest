package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
//		int[] arr = {2,4,5,8,6};
//		selectArr(arr);
		List<Integer> asList = Arrays.asList(1,2,3,4,5,6,2,1,7,3,9,2);
		Collections.sort(asList);
		for(Integer integer :asList){
			System.out.println(integer);
		}
	}
	public static void selectArr(int[] arr){
		
		for(int i = 0;i<arr.length-1;i++){
			
			for(int x=i+1;x<arr.length;x++){
				
				if(arr[i]>arr[x]){
					int temp = arr[i];
					arr[i] = arr[x];
					arr[x] = temp;
					
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
