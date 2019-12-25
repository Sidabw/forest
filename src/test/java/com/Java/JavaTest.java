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
    public void test2(){
//<<<<<<< HEAD
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(2);
        System.out.println(2);
//=======
        System.out.println(22);
        System.out.println(22);
        System.out.println(22);
        System.out.println(22);
        System.out.println(22);
        System.out.println(22);
//>>>>>>> develop-v2
        System.out.println(2);
        System.out.println(2);
        System.out.println(2);
    }


    @Test
    public void test1(){
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
    }

}
