package com.grammer.test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Demo91 {
	public static void main(String[] args) throws Exception{
		System.out.println("��������Ա����");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		FileReader fr = new FileReader("player.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		boolean flag=true;
		while((line=br.readLine())!=null){
			String[] split = line.split(",");
			String name = split[0];
			String team = split[1];
			if(s.equals(name)){
				flag=false;
				System.out.println(name+"����"+team);
				br.close();
				fr.close();
				return;
			}
		}
		if(flag){
			System.out.println("û�и���Ա");
		}
		br.close();
		fr.close();
		
	}
}
