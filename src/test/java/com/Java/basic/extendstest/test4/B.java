/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: B
 * Author:   feiyi
 * Date:     2020/1/6 4:30 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test4;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/1/6
 * @since 1.0.0
 */
public class B extends A{

    //TODO  需要好好复习一下Java的子父类属性的覆盖
    protected static String staticStr = "b";

    protected String str = "b";

    public static void main(String[] args) {
        System.out.println(new B().getStaticStr());
        System.out.println(A.staticStr);
        System.out.println(B.staticStr);
        System.out.println("⬆");

        //神奇啊............
        //override只支持method，不支持column
        System.out.println(new B().getStr());
        System.out.println(new B().getStr2());
        System.out.println(new B().str);
    }

    protected String m1() {
        return str;
    }

}
