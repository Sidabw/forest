/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: JSONPathDemo
 * Author:   feiyi
 * Date:     2020/1/7 7:48 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.jsonpath;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.junit.Test;

import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈https://github.com/json-path/JsonPath〉
 *
 * @author feiyi
 * @create 2020/1/7
 * @since 1.0.0
 */
public class JsonPathDemo {

    private String originStr = "{\n" +
            "    \"store\": {\n" +
            "        \"book\": [\n" +
            "            {\n" +
            "                \"category\": \"reference\",\n" +
            "                \"author\": \"Nigel Rees\",\n" +
            "                \"title\": \"Sayings of the Century\",\n" +
            "                \"price\": 8.95\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"Evelyn Waugh\",\n" +
            "                \"title\": \"Sword of Honour\",\n" +
            "                \"price\": 12.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"Herman Melville\",\n" +
            "                \"title\": \"Moby Dick\",\n" +
            "                \"isbn\": \"0-553-21311-3\",\n" +
            "                \"price\": 8.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"J. R. R. Tolkien\",\n" +
            "                \"title\": \"The Lord of the Rings\",\n" +
            "                \"isbn\": \"0-395-19395-8\",\n" +
            "                \"price\": 22.99\n" +
            "            }\n" +
            "        ],\n" +
            "        \"bicycle\": {\n" +
            "            \"color\": \"red\",\n" +
            "            \"price\": 19.95\n" +
            "        }\n" +
            "    },\n" +
            "    \"expensive\": 10\n" +
            "}";

    @Test
    public void test1() {
        //1.(方式一)
        DocumentContext context = JsonPath.parse(originStr);
        System.out.println(context.read("$.store.book[1].author").toString());
        //1.1(方式二)
        System.out.println(JsonPath.read(originStr, "$.store.book[1].author").toString());
        //2.
        System.out.println(context.read("$.store.book[*].author").toString());
        //3.
        System.out.println(context.read("$..author").toString());
        //4.
        System.out.println(context.read("$..book.length()").toString());
        //5.give me everything
        Object obj = context.read("$");
        System.out.println(obj.toString());
    }

    @Test
    public void test2() {
        DocumentContext context = JsonPath.parse(originStr);
        //方法上的泛型是这么用的...
        //当然下面两种肯定会有一个throw an java.lang.ClassCastException
        String result = context.read("$.store.book[1].author");
        List<String> result2 = context.read("$.store.book[1].author");
    }

    @Test
    public void test3() {
        JSONObject jsonObject = JSONObject.parseObject(originStr);
        //parse一个jsonObj也是可以的
        DocumentContext context = JsonPath.parse(jsonObject);
        System.out.println(context.read("$.store.book[1].author").toString());
    }

    //异常
    @Test
    public void test4() {
        Configuration conf = Configuration.defaultConfiguration();
        //真的是奇怪的用法...
        Configuration conf2 = conf.addOptions(Option.SUPPRESS_EXCEPTIONS);
        DocumentContext context = JsonPath.using(conf2).parse(originStr);
        Object read1 = context.read("$.store.book1");
        Object read2 = context.read("$.store.author");
        System.out.println(read1);
        System.out.println(read2);
    }
}
