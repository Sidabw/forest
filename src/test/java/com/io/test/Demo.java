package com.io.test;

import java.io.File;

/***
 *  Created by shao.guangze on 2018/8/15
 */
public class Demo {
    public static void main(String[] args){
        File file = new File("C:\\Users\\think\\Desktop\\dir2\\2\1");
        System.out.println(file.isDirectory());
        file.mkdir();
        System.out.println(file.isDirectory());
    }
}
