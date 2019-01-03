package com;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Long date = new Long("1528793116000");
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(new Date(date)));
		System.out.println(new Date());
		System.out.println("======		String Test		  ======");
		String str = "我爱吃面包5";
		byte[] bytes = str.getBytes();
		for(byte e : bytes){
			System.out.print(e + " ");	//result: -26 -120 -111 -25 -120 -79 -27 ......		[size:16]
		}
		System.out.println(" ");
		String str2 = "1234567890";
		byte[] bytes2 = str2.getBytes();
		for(byte e2 : bytes2){
			System.out.print(e2 + " ");		//result: 对应的ASCII值
		}
		System.out.println("/r/n");
		System.out.println("================");
		String null1 = null;
		String str1 = "abc";
		String null2 = null;
		System.out.println(null1 + str1 + null2);

		DigestUtils.md5Hex("");
		System.out.println("-----------------------------");
        System.out.println(1%10);
		/*User user = new User("面包",1);
		User user2 = user;
		user2.setGender(0);
		System.out.println(user.getGender());*/
		
		
		
		
		/*String str = "我爱吃萝卜头你呢1a";
		char[] charArray = str.toCharArray();
		System.out.println(charArray.length);
		System.out.println(charArray);
		for (char each : charArray) {
			System.out.println(each);
			System.out.println((Integer.valueOf(each) > 33) && (Integer.valueOf(each) < 127));
			
//			judeg(each);
			//33 127
			if (each == '我') {
				System.out.println("ininininininininininininin");
			}
			
		}*/
		/*UserExample userExample = new UserExample();

        System.out.println("-----------------------------------");
        List<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        System.out.println((JSONObject)list);*/
//        Object user = new User();
//        System.out.println((Map) user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("n", 10000000000L);
        System.out.println(jsonObject.get("n"));
        System.out.println(jsonObject.toJSONString());

        System.out.println("--------------------");
        System.out.println(new Integer(1) == new Integer(1));
    }

	public static void judeg(char each) {
		char[] arr = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9' };
		for(int i = 0 ; i<arr.length ; i ++){
			if(arr[i] == each){
				System.out.println("ininininininininin");
			}
		}
	}
}
class User{
	private String username;
	private Integer gender;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public User(String username, Integer gender) {
		super();
		this.username = username;
		this.gender = gender;
	}
}
/*
 * AaBbCcDdEeFfGgHhIi JjKkLlMmNnOoPpQqRr SsTtUuVvWwXxYyZz
 */