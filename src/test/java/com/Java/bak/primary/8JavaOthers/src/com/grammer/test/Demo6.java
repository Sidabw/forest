package com.grammer.test;
import java.util.Scanner;

public class Demo6 {
	public static void main(String[] args) {
		test();
	}
	public static void test(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ���ַ�����һ���ַ�������֮���ö��Ÿ���");
		String allStr=scanner.nextLine();
		String[] split = allStr.split(",");
		String str=split[0];
		String str2=split[1];
		int index = str.indexOf(str2);
		int flag=0;
		while(index!=(-1)){
			System.out.print(index+" ");
			flag++;
			index=str.indexOf(str2, index+1);
		}
		if(flag==0){
			System.out.println(-1);
		}
	}
}
