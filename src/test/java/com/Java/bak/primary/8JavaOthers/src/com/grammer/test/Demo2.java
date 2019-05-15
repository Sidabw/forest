package com.grammer.test;
public class Demo2 {
  public static void main(String[] args)
  {
	  /**
	   * 判断一个数组中只出现1次的数的个数
	   * */
	  int[] arr={1,2,3,4,5,6,7,1,4,6,2,5,97,123,323,43,62,12};
	  int count=0;
	  for(int i=0;i<arr.length;i++){
		  for(int j=0;j<arr.length;j++){
			  if(i==j){
				  continue;
			  }
			  if(arr[i]==arr[j]){
				  break;
			  }
			  if(j==arr.length-1){
				  count++;
			  }
		  }
	  }
	  System.out.println(count);
	 // System.out.println(arr.length);
	/**
	 * 
	 *水仙花数:(267=2^3+6^3+7^3)
	 * */
			for(int x=100;x<=999;x++)
			{
				int a=x/100;
				int b=(x-(a*100))/10;
				int c=x-(a*100)-(b*10);
				int d=(a*a*a)+(b*b*b)+(c*c*c);
				if(d==x)
					System.out.println(d);
			}

			int a=1;
			System.out.println(a+=1);
			System.out.println(a++);
			System.out.println(Integer.toHexString(60));
  }
}

