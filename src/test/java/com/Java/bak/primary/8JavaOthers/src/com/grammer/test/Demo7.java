package com.grammer.test;
public class Demo7 {
	public static void main(String[] args) {
//		String str="asjdlkjavalsdg";
//		String a="java";
//		int indexOf = str.indexOf(a);
//		System.out.println(str.substring(indexOf,indexOf+a.length()));//subString 包头不包尾
		
		String str="asjdlkjavalsdg";
		String[] split = str.split("java");
		System.out.println(split.length-1);
		
		Student student=new Student();
		System.out.println(student.a);
		new Student();
	}
}
class Student{
	int a=0;
	final int b;
	public Student(){
		b=200;
	}
	public void show(){
		System.out.println("fu");
	}
}
class Sida extends Student{
	public void show(){
		System.out.println("zi..");
	}
	
}
