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

import com.Java.basic.extendstest.test1.Son;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

        System.out.println("----------");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 0);
        System.out.println(new SimpleDateFormat("yyyy").format(instance.getTime()));
    }

    @Test
    public void test6() {
        //i-- i++测试
        int[] arr2 = {1, 2, 3, 4, 5};
        int i = 4;
        int j = 4;
        while (arr2[i] > 2) {
            i--;
        }
        while(arr2[j--] > 2) {}
        System.out.println(i);  //输出：1
        System.out.println(j);  //输出：0
    }

    /**
     * @Description 元素迭代的时候remove必须使用迭代器. jdk1.8之后新增了removeIf方法
     * 注意：下面只有方式二好使，因为方式一返回的是一个假的ArrayList(是Arrays的静态内部类)
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/12/23 4:00 PM
     **/
    @Test
    public void test7 () {
        //方式一
//        List<String> strs = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        //方式二
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("e");
        strs.add("f");
        strs.add("g");

        //
        Iterator<String> iterator = strs.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("b")) {
                iterator.remove();
            }
        }

        System.out.println("------------------------------------------------------");
        //
        strs.removeIf(e -> {
            System.out.println(e);
            return "d".equals(e);
        });

    }

    @Test
    public void testIo() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/feiyi/Desktop/20191214预发user重复数据删除"));
        System.out.println(fileInputStream.available());
        byte[] bytes = new byte[1024];
        int len = 0;

        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/feiyi/Desktop/20191214预发user重复数据删除2"));
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(len);
            fileOutputStream.write(bytes, 0, len);
        }
    }


    @Test
    public void testTime(){
        long l1 = Double.valueOf(1577693319.86831 * 1000).longValue();
        System.out.println();
        Date date = new Date(l1);
        Date date2 = new Date(1577693319868L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date));

        int i = 0;
        int j = 0;

        int a = i++;
        int b = ++j;
        System.out.println(a);
        System.out.println(b);
        System.out.println(i++);
        System.out.println(++j);
    }


    //unicode 转 utf-8
    //
    @Test
    public void encodingTest() throws UnsupportedEncodingException {
        String str = "21\u4e16\u7eaa\u7ecf\u6d4e\u62a5\u9053";
        System.out.println(new String (str.getBytes(), "UTF-8")); //21世纪经济报道

        String str2 = "\u83b7\u53d6\u62bd\u53d6\u6570\u636e\u5931\u8d25";
        System.out.println(new String (str2.getBytes(), "UTF-8")); //获取抽取数据失败
    }

    @Test
    public void regexTest(){
        String str = "aa$.bb";
        String str2 = "aa$bb.cc";
        //index of 不接受regex...
        System.out.println(str.indexOf("\\."));

        String str3 = " $.param.meta_info";
        String substring = str3.substring(2);
        System.out.println(substring);
    }

    @Test
    public void test1(){
        Son son1 = new Son();
        son1.setAge(1);

        List<Son> sons = Arrays.asList(son1);
        test1S(sons);
        System.out.println(sons.get(0).getAge());

        Son son = new Son();
        son.setAge(11);
        son11(son);
        System.out.println(son.getAge());
    }

    public static void son11(Son son) {
        Son son1 = new Son();
        son1.setAge(12);

        son = son1;

    }




    //在方法内部直接通过改变引用的方式改变对象是无效的。
    public static void test1S(List<Son> sons) {
        Son son = new Son();
        son.setAge(2);
        sons = Arrays.asList();
    }

}
