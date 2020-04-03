package com.Java.streamAndAll.sysLearning.interfaceDemo;

public class MyActionClass {

    public static void main(String[] args) {
        /*
       new MyActionInterface(){
            @Override
            public void saySomeThing(String str) {
                System.out.println(str);
            }
        }.saySomeThing("Hello world function");
        */
        MyActionInterface action = s -> System.out.println(s);
        action.saySomeThing("Hello world function");

        //Default methods cannot be accessed from within lambda expressions.
//        MyActionInterface actionDefault =
    }
}
