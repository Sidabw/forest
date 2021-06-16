/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Demo3 Author:   shaogz Date:     2021/6/16 2:15 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.widget.json.jackson.pojo.p3.Person3;
import org.junit.Test;

import java.io.IOException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/6/16
 * @since 1.0.0
 */
public class Demo3 {

    @Test
    public void test1() throws IOException {
        String jsonStr = new ObjectMapper().writeValueAsString(new Person3("sida", "brew", true));
        System.out.println(jsonStr);

        Person3 person3 = new ObjectMapper().readValue(jsonStr, Person3.class);
        System.out.println(person3.getIsMale());
    }

    @Test
    public void test2() throws IOException {
        //JsonNode是不可变的，只读。要进行写的操作时，需使用其子类：ObjectNode ArrayNode...
        String jsonStr = "{\"firstname\":\"sida\",\"lastname2\":\"brew\"}";
        JsonNode jsonNode = new ObjectMapper().readTree(jsonStr);
        System.out.println(jsonNode.get("firstname").asText());
        //类似json path的功能：/a/b/c
        System.out.println(jsonNode.at("/firstname").asText());

        //写操作
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.setAll((ObjectNode)jsonNode);
        objectNode.put("lastname2","brew2");
        System.out.println(objectNode.get("firstname"));
        System.out.println(objectNode.get("lastname2"));
    }
}
