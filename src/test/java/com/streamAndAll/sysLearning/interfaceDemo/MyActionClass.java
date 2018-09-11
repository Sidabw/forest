package com.streamAndAll.sysLearning.interfaceDemo;

public class MyActionClass {
	 /**
     * 执行接口中的saySomeThing方法
     * 不再使用匿名内部类的方式，直接传入一个Consumer作为方法的实现。
     * 具体是哪个方法的实现，在所调用的excuteSay这个方法的方法体中。
     * @param action
     * @param thing
     */
    public static void excuteSay(MyActionInterface action,String thing){
        action.saySomeThing(thing);
    }

    public static void main(String[] args) {
        /*
        excuteSay(new MyActionInterface(){
            @Override
            public void saySomeThing(String str) {
                System.out.println(str);
            }
        },"Hello World");
        */
        excuteSay(s -> System.out.println(s),"Hello world new");
    }
}
