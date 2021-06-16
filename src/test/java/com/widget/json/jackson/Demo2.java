/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Demo2 Author:   shaogz Date:     2021/6/16 2:11 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.widget.json.jackson.pojo.p2.Person2;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/6/16
 * @since 1.0.0
 */
public class Demo2 {

    @Test
    public void test4() throws IOException {
        //序列化时，Date对象会默认转成时间戳，可以添加DateFormat来解决
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        String jsonStr1 = mapper.writeValueAsString(buildPerson2());
        System.out.println(jsonStr1);

        //反序列化时，如果实体类有一些字段没有，会报错，添加DeserializationFeature来解决
        String jsonStr2 = "{\"firstname\":\"sida\",\"lastname2\":\"brew\"}";
        ObjectMapper mapper2 = new ObjectMapper();
        mapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Person2 person2 = mapper2.readValue(jsonStr2, Person2.class);
        System.out.println(person2.getLastname());
    }

    @Test
    public void test5(){
        //有一些字段序列化/反序列化时希望被忽略，怎么办？
        //m1: 在期望忽略的字段上添加@JsonIgnore
        //m2: 在类上声明@JsonIgnoreProperties({"brithday"})， 里面时忽略字段
        //m3: 某一个实例域也是1个POJO，n个类都把该POJO放到了实例域上，所以我想忽略这个类需要在n个类的这个实例域加上@JsonIgnore???
        //可以在这个POJO上加@JsonIgnoreType


        //有一些字段如果为空的化，序列化时不要序列化这个字段，怎么办？
        //类上添加@JsonInclude(JsonInclude.Include.NON_EMPTY)

        //@JsonProperty更改序列化/反序列化时使用不同的name
        //@JsonAlias 反序列化时将多个key映射到当前属性上

        //序列化时指定顺序
        //类上添加@JsonPropertyOrder({"firstname", "lastname", "birthday"})

        //@JsonRawValue 对应json格式的String类型

    }

    private Person2 buildPerson2() {
        return new Person2("sida", "brew", new Date());
    }


}
