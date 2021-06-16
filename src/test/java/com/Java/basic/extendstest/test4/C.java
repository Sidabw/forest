/**
 * Copyright (C), 2018-2021, bokecc.com FileName: C Author:   shaogz Date:     2021/5/8 11:53 AM Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test4;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/5/8
 * @since 1.0.0
 */
public class C {

    public static void main(String[] args) {
        System.out.println(new B().getStaticStr());
        System.out.println(A.staticStr);
        System.out.println(B.staticStr);
        System.out.println("⬆");
        //override只是method，没有column

        System.out.println(new B().getStr());
        System.out.println(new B().getStr2());
        System.out.println(new B().str);


        int a =2;
        int b =3;
        float c= a /b;
        System.out.println(c);
    }

    // public <T> T a(){
    //     return new Object();
    // }

}
