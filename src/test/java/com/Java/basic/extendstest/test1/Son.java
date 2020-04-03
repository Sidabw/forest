/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Son
 * Author:   feiyi
 * Date:     2018/12/6 上午10:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test1;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/6
 * @since 1.0.0
 */
public class Son extends Parent {

    private static String a;

    static {
        a = "子类静态成员变量，被子类静态代码块赋值";
        System.out.println(a);
    }

    private String b;

    {
        b = "子类非静态成员变量，被子类非静态代码块赋值";
        System.out.println(b);

    }
    public Son(){
        System.out.println("子类构造函数");
    }
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
