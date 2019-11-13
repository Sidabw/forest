/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/4/9 7:45 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/9
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args){
//        char a = 'a';
//        int ai = 0;
////        ai = a + 1;
//        System.out.println(a);
        Son son = new Son();
        son.setName("s1");
        Son son2 = new Son();
        son2.setName("s2");
        ArrayList<Son> sons = new ArrayList<>();
        sons.add(son);
        sons.add(son2);
        Map<String, List<? extends Parent>> aa = Collections.singletonMap("aa", sons);
        test1(aa);

    }

    public static void test1(Map<String, List<? extends Parent>> person){

//        person.forEach(e -> System.out.println(e.getName()));
    }
}
