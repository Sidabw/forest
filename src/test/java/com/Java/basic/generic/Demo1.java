/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo1
 * Author:   feiyi
 * Date:     2020/3/19 8:45 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.generic;


import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/3/19
 * @since 1.0.0
 */
public class Demo1 {

    public static void main(String[] args) {
        B2 b2 = new B2();
        ArrayList<Object> objects = new ArrayList<>();
        b2.eq(objects); //B2
        Collection col = objects;
        b2.eq(col); //c1

        Son son = new Son();
        son.m1(1);
        son.m1("11");//这本身就是一个桥方法。因为Father实际只有一个 m1(Object)的方法

        //传递是引用，故而引用类型即栈类型是什么，那么调用的时候就去找参数列表是该栈类型的..
        Son2 son2 = new Son2();
        son2.m1(new Object());
        son2.m1("222");
        Object strObj = "aa";
        son2.m1(strObj);

        mm(new Father<C1>());
        mm(new Father<B2>());
//        mm(new Father<Son>());//这样的就编译错误🙅‍了。
    }


    public static void mm(Father<? extends C1> f) {

    }
}


//准确的说，这是一个方法的重载和多态造成冲突的问题
//B2编译后会拥有两个eq方法，父类的eq方法会被jvm修改为一个桥方法，
//指向B2原有的eq,却依然调用自己的方法。。 这算哪门子指向啊
class C1 {
    public void eq(Collection col) {
        System.out.println("c1");
    }
}

class B2 extends C1 {
    public void eq(List list) {
        System.out.println("B2");
    }
}


class Father<T> {

    public void m1(T t) {
        System.out.println("father");
    }
}

class Son extends Father<String> {

    public void m1(Integer i) {
        System.out.println("son");
    }

}

class Son2 {

    public void m1(String str) {
        System.out.println("String");
    }

    public void m1(Object str) {
        System.out.println("Object");
    }

}

//测试桥方法
//这样写是编译不过的，

//class F1 {
//
//    public String m1(){
//        return "f1";
//    }
//
//}
//
//class Son3 extends F1 {
//
//    public Integer m1() {
//
//    }
//}

