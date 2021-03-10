/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: Outer
 * Author:   feiyi
 * Date:     2021/2/23 3:53 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.innerclass.p3;

/**
 * 〈一句话功能简述〉:
 * 〈局部内部类的基础写法〉
 *
 * @author feiyi
 * @create 2021/2/23
 * @since 1.0.0
 */
public class Outer {

    private int age = 22;

    public void outerMethod() {
        //jdk1.8之后不加final也没关系了，jdk给默认加上了。
        final int gender = 2;
        class Inner {
            public int getGender () {
                return gender;
            }
        }
        int gender1 = new Inner().getGender();
        System.out.println(gender1);
    }

    public static void main(String[] args) {
        new Outer().outerMethod();
    }
}
