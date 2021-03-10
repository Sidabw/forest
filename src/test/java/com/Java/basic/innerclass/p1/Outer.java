/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: Outer
 * Author:   feiyi
 * Date:     2021/2/23 3:44 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.innerclass.p1;

/**
 * 〈一句话功能简述〉:
 * 〈成员内部类的基础写法〉
 *
 * @author feiyi
 * @create 2021/2/23
 * @since 1.0.0
 */
public class Outer {

    private int age = 20;

    class Inner {
        public void getAge(){
            System.out.println(age);
        }
    }

}

class OuterTest {

    public static void main(String[] args) {
        //最基础的成员内部类写法
        Outer.Inner inner = new Outer().new Inner();
        inner.getAge();
    }

}
