package com.grammer.test;
import java.util.Random;
/**
 * 根据给定数组，利用Random取出其中三个数，要求三个数不能重复
 * */
public class Demo3 {
	public static void main(String[] args) {
		int[] arr={2,3,4,5,6,7,1,34,68,93};
		int[] arrtemp=new int[3];
		Random random = new Random();
		int randomtemp;
		while(true){
			int flag=0;
			int random1=random.nextInt(arr.length-1);
			int random2=random.nextInt(arr.length-1);
			int random3=random.nextInt(arr.length-1);
			arrtemp[0]=random1;
			arrtemp[1]=random2;
			arrtemp[2]=random3;
			for(int i=0;i<arrtemp.length-2;i++){
				for(int j=i+1;j<arrtemp.length-1;j++){
					if(arrtemp[i]==arrtemp[j]){
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
				if(i==arrtemp.length-3){
					System.out.println(arr[random1]);
					System.out.println(arr[random2]);
					System.out.println(arr[random3]);
					return;
				}
			}
		}
	}
}
