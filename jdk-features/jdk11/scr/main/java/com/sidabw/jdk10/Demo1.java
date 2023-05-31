package com.sidabw.jdk10;

import java.util.ArrayList;

/**
 * @author shaogz 2023/5/6 15:42
 */
public class Demo1 {

    public static void main(String[] args) {
        //局部变量，增强for循环的索引，以及传统for循环的本地变量
        var a  = new ArrayList<Boolean>();
        a.add(Boolean.TRUE);
        System.out.println(a.size());


        ArrayList<Boolean> a2 = new ArrayList<>();
        for (var each : a2) {
            System.out.println(each);
        }
    }
}
