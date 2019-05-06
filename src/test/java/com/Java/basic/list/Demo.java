
package com.Java.basic.list;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

//import net.minidev.json.JSONArray;

public class Demo {
	public static void main(String[] args){
		HashMap<String, Map<String , List>> map = new HashMap<>();
		HashMap<String, List> mapContent = new HashMap<>();
		ArrayList<User> dataList = new ArrayList<>();
		User zhangsan = new User("zhangsan", 1);
		dataList.add(zhangsan);
		mapContent.put("data_list", dataList);
		map.put("content", mapContent);
		//
		System.out.println(JSONObject.toJSONString(map));
		User o1 = (User)map.get("content").get("data_list").get(0);
		o1.setGender(0);
		System.out.println(JSONObject.toJSONString(map));
		System.out.println("---------------------------");
		List<Object> list = new ArrayList<Object>();
		list.add(new User("zhangsan",1));
		ArrayList<User> arrayList = new ArrayList<User>();
		arrayList.add(new User("lisi",0));
		arrayList.add(new User("wangwu",0));
		list.add(arrayList);
		System.out.println(JSONArray.toJSONString(list));
		List o = (List)list.get(1);
		o.remove(0);
		System.out.println(JSONArray.toJSONString(list));
		System.out.println("-----------------------------");
		for(int i = 0 ; i < arrayList.size() ; i ++){
			User user = arrayList.get(i);
			if(user.getName().equals("lisi")){
				user.setGender(1);
			}
		}
		/*for(User user: arrayList){
			if(user.getName().equals("lisi")){
				user.setGender(1);
			}
		}*/
		for(User user : arrayList){
			System.out.println(user.getGender());
		}

		List<List<?>> lists = Arrays.asList(list, arrayList);

	}


	@Test
	public void testShuffle(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers);
        Collections.shuffle(integers);
        System.out.println(integers);
    }
}
class User{
	private String name;
	private Integer gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + "]";
	}
	public User(String name, Integer gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
}
