package com.Java.bak.middle.Json.src.main.java.com.beta.fastjson;

 


import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * */
public class Demo {

	public static void main(String[] args) {
		
	}

	/**
	 * string --->json json--->String
	 * */
	@Test
	public void test() {
		Object parse = JSONObject.parse(json);
		System.out.println(parse);
		String string = JSONObject.toJSONString(parse);
		System.out.println(string);
	}
	
	public void meth(){
		System.out.println(111);
	}
	@Test
	public void fastJson() {
		String jsonExam = "{\"userTitle\":\"π派先生\",\"createTime\":\"2017/12/13\",\"recommendPackage\":\"CustomFofs\",\"recommendInsurances\":[],\"recommendPackageProducts\":[\"平衡型组合\"],\"dataMap\":{\"assetDiagnoseList\":[],\"investDiagnoseList\":[{\"pageRemark\":\"收益目标\",\"pageTitle\":\"symb\",\"label\":{\"label\":\"险益相伴\"}},{\"pageRemark\":\"投资心态\",\"pageTitle\":\"tzxt\",\"label\":{\"label\":\"心存焦虑\"}},{\"pageRemark\":\"收入支出\",\"pageTitle\":\"srzc\",\"label\":{\"label\":\"入不敷出\"}},{\"pageRemark\":\"家庭保障\",\"pageTitle\":\"jtbz\",\"label\":{\"label\":\"缺乏保障\"}}]}}";
		// 先把json格式的字符串传函为json对象 ps:直接parse(str)的话得到的是Object
		JSONObject parseObject = JSONObject.parseObject(jsonExam);
		/**
		 * 在json.cn看一下json字符串的格式。key对应的是普通对象（String）还是依然是一个json对象
		 * JSONObject.get("")得到的是普通对象，JSONObject.getJSONObject("")得到的是普通对象
		 * */
		String str = (String) parseObject.get("userTitle");
		System.out.println(str);
		JSONObject datamap = parseObject.getJSONObject("dataMap");
		JSONArray jsonArray = datamap.getJSONArray("investDiagnoseList");
		/**
		 * 问题：去除包含指定字符串的jsonObject
		 * 主要是JSONObject的toJSONString方法和JSONArray的remove方法
		 * */
		for (int i = 0; i < jsonArray.size(); i++) {
			Object object = jsonArray.get(i);
			String jsonString = JSONObject.toJSONString(object);
			if(jsonString.contains("家庭保障")){
				jsonArray.remove(i);
			}
		}
		//需要重新put一遍，覆盖掉原来的
		datamap.put("investDiagnoseList", jsonArray);
		parseObject.put("dataMap", datamap);

	}

	// json string
	private static String json = "{\"id\":1,\"title\":\"德国黑森林罕见暴雨把路面冲走\",\n"
			+ "    \"questions\":[\n"
			+ "        {\"sequence\":1,\"title\":\"你是那个?\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":2,\"title\":\"德国黑森林罕见暴雨把路面冲走\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":3,\"title\":\"德国黑森林罕见暴雨把路面冲走\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":4,\"title\":\"你是那个\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":5,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":6,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":7,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":8,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":9,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":10,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":11,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":12,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":13,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":14,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":15,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":16,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":17,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":18,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":19,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]},\n"
			+ "        {\"sequence\":20,\"title\":\"美海豚伤痕累累疑曾遭虎鲸整只吞食\",\"answers\":[{\"result\":\"A:姓名\"},{\"result\":\"B:六哈\"},{\"result\":\"C:积分\"},{\"result\":\"D:金佛额\"}]}\n"
			+ "        ]\n" + "}";
}
