/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: Outer
 * Author:   feiyi
 * Date:     2021/2/23 3:47 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.innerclass.p2;

/**
 * 〈一句话功能简述〉:
 * 〈成员内部类的优化写法〉
 *
 * @author feiyi
 * @create 2021/2/23
 * @since 1.0.0
 */
public class Outer {

    private int age = 20;

    //把内部类标记private之后，就只能在本类调用
    private class Inner {
        public void getAge(){
            System.out.println(age);
        }
    }

    public Inner getInner(){
        //可以在这里做一些判断处理。。
        return new Inner();
    }

    public static void main(String[] args) {
        //成员内部类的优化写法
        new Outer().getInner().getAge();
    }
}

class OuterTest {
    public static void main(String[] args) {
        //以下写法都报错，因为内部类吗是private的
//        Outer.Inner inner = new Outer().getInner();
//        new Outer().getInner().getAge();
    }
}
