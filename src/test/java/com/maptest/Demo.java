
package com.maptest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Demo {
	public static void main(String[] args){
		HashMap<String, String> hashMap = new HashMap<String,String>();
		System.out.println(hashMap.keySet());
		System.out.println(hashMap.keySet().iterator());
		System.out.println(hashMap.keySet().iterator().hasNext());
		Sida sida = new Sida();
		sida.setAge(11);
		System.out.println(sida.getAge());
		System.out.println(sida.getGender());
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//System.out.println(arrayList.get(0));
		int i = 0;
		while(i < 10){
			if(i == 6){
				break;
			}
			
			System.out.println(i);
			i++;
		}
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日HH时").format(new Date(345398400000L)));
		
	}
}
class Sida{
	private String gender = "women";
	private Integer age;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
