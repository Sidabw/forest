/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Test
 * Author:   feiyi
 * Date:     2018/12/6 上午10:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.javatest.test.extendstest;

import io.netty.util.internal.ObjectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/6
 * @since 1.0.0
 */
public class Test {

    @org.junit.Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Son son = new Son();
        son.setAge(10);
        son.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        son.setName("sidabw");
        Class<? extends Son> sonClass = son.getClass();
        System.out.println(sonClass.getDeclaredFields().length);
        Field[] declaredFields = son.getClass().getSuperclass().getDeclaredFields();
        System.out.println(declaredFields.length);
        son.getClass().getSuperclass().getDeclaredMethod("setName", String.class).invoke(son, "brew");
        System.out.println(son.getName());
        //for test
        int i = 2;
        for (; i < 3 ; i = 3){
            System.out.println(i);
        }
        Field age = son.getClass().getDeclaredField("age");
        age.setAccessible(true);
        age.set(son, 11);
        System.out.println(son.getAge());
        System.out.println("--------------------------");
        //获取父类field ; accessible; 传入子类对象 set value；ok....
        Field name = son.getClass().getSuperclass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(son, "breww");
        System.out.println(son.getName());
    }
}
