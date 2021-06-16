/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Demo Author:   shaogz Date:     2021/6/16 12:02 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.widget.json.jackson.pojo.p1.Address;
import com.widget.json.jackson.pojo.p1.Person;
import com.widget.json.jackson.pojo.p1.PhoneNumber;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈 blog地址： https://blog.csdn.net/shangboerds/article/details/90543128〉
 *
 * @author shaogz
 * @create 2021/6/16
 * @since 1.0.0
 */
public class Demo1 {

    @Test
    public void test1() throws IOException {
        //基础序列化
        String jsonStr = new ObjectMapper().writeValueAsString(buildPerson());
        System.out.println(jsonStr);
        //基础反序列化
        Person person = new ObjectMapper().readValue(jsonStr, Person.class);
        System.out.println(person.getAddress().getStreet());
        System.out.println("part-1 👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆");
    }

    @Test
    public void test2() throws IOException {
        String jsonStr2 = "[{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}, {\"firstname\":\"San\",\"lastname\":\"Zhang\"}]";
        //反序列化为数组
        Person[] person2 = new ObjectMapper().readValue(jsonStr2, Person[].class);
        System.out.println(person2[1].getFirstname());
        //反序列化为集合(IDEA猜不出来.. 需要手动指定返回值)
        List<Person> person3 = new ObjectMapper().readValue(jsonStr2, new TypeReference<List<Person>>(){});
        System.out.println(person3.get(1));
        //反序列化为Map
        String jsonStr4 = "{\"firstname\":\"Bo\",\"lastname\":\"Shang\"}";
        Map<String, Object> person4 = new ObjectMapper().readValue(jsonStr4, new TypeReference<Map<String, Object>>(){});
        System.out.println(person4.get("firstname"));
    }

    @Test
    public void test3() throws IOException {
        //其他的读和写

        //读
        // readValue(String src, ...)
        // readValue(File src, ...)
        // readValue(URL src, ...)
        // readValue(InputStream src, ...)
        // readValue(DataInput src, ...)
        // readValue(Reader src, ...)
        // readValue(byte[] src, ...)

        //写
        // writeValueAsString(...)
        // writeValue(File desc, ...)
        // writeValue(File desc, ...)
        // writeValue(OutSteam desc, ...)
        // writeValue(DataOutput desc, ...)
        // writeValue(Writer desc, ...)
        // writeValueAsBytes(...)

    }



    private static Person buildPerson() {
        List<PhoneNumber> phones = new ArrayList<>();

        PhoneNumber phone = new PhoneNumber();
        phone.setCode("86");
        phone.setNumber("0411-12345678");
        phones.add(phone);

        PhoneNumber cell = new PhoneNumber();
        cell.setCode("86");
        cell.setNumber("18912345678");
        phones.add(cell);

        Address address = new Address();
        address.setState("LiaoNing");
        address.setCity("DaLian");
        address.setStreet("GaoXingQu");

        Person shangbo = new Person();
        shangbo.setFirstname("Bo");
        shangbo.setLastname("Shang");
        shangbo.setAddress(address);
        shangbo.setPhones(phones);

        return shangbo;
    }
}
