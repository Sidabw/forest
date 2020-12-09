/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/10/27 5:56 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.LinkedHashMap;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/27
 * @since 1.0.0
 */
public class Demo {

    private static final String origin = "{\n" +
            "\t\"abc\": {\n" +
            "\t\t\"asdfasd\": \"aa\",\n" +
            "\t\t\"hfdgsh\": \"aa\",\n" +
            "\t\t\"adsfsdssfasdf\": \"aa\",\n" +
            "\t\t\"cvsdfg\": \"aa\"\n" +
            "\t}\n" +
            "}";

    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = JSONObject.parseObject(origin, LinkedHashMap.class, Feature.OrderedField);
        System.out.println(linkedHashMap.get("abc").getClass());
        System.out.println(JSONObject.toJSONString(linkedHashMap.get("abc")));

//        JSONObject jsonObject = JSONObject.parseObject(origin);
//        System.out.println(jsonObject.getJSONObject("abc").toJSONString());
    }
}
