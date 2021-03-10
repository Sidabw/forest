/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: Outter
 * Author:   feiyi
 * Date:     2021/2/23 3:59 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.innerclass.p4;

/**
 * 〈一句话功能简述〉:
 * 〈静态内部类的基础写法〉
 *
 * @author feiyi
 * @create 2021/2/23
 * @since 1.0.0
 */
public class Outer {

    private static int age = 21;

    private int age2 = 22;

    static class Inner {

        public int getAge(){
            //age2是访问不了的
            return age;
        }

    }

}

class Test {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        int age = inner.getAge();
        System.out.println(age);
    }
}
