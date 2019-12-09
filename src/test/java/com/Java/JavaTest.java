/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: JavaTest
 * Author:   feiyi
 * Date:     2019/4/21 9:54 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/21
 * @since 1.0.0
 */
public class JavaTest {



    @Test
    public void test3(){
//        double rd = Math.random();
//        System.out.println(rd);
//        String rdStr = String.format("%." + (3 - 1) + "f", rd).replace("0.", "") + (int)(Math.random() * 10.0D) % 10;
//        System.out.println(rdStr);
//        System.out.println("---");
//        System.out.println(String.format("%.2f", 0.444));
        JavaTest javaTest = new JavaTest();
        while (true){
            String result = javaTest.randomTest(3);
            if (result.contains("\\.")) {
                System.out.println(result);
                break;
            }
        }
    }

    public String randomTest(int digit){
        double rd = Math.random();
        String rdStr = String.format("%." + (digit - 1) + "f", rd).replace("0.", "") + (int)(Math.random() * 10.0D) % 10;
        return rdStr;
    }

    @Test
    public void test5(){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(map.getOrDefault("aa", "asdfsdf"));
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        map.put("a", "b");
        map.put("b", "c");
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject.getString("a"));
        jsonObject.remove("a");
        System.out.println(map.get("a"));
        Map<String, String> map2 = Collections.singletonMap("a", "v");
        map.put("c",map2);
        System.out.println(jsonObject.getJSONObject("c") == jsonObject.getJSONObject("c"));
//        System.out.println(jsonObject.getJSONObject("c").get("a"));
//        jsonObject.getJSONObject("c").put("a", "aaa");
//        System.out.println(map2.get("a"));
    }
}
