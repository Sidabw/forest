package com.sidabw.jdk9;

/**
 * @author shaogz 2023/5/6 14:52
 */
public interface Demo2 {
    void a(int a1);

    //jdk1.8可以在接口上添加一些default函数。
    default String a2(){return null;}

    default String aa(){return doInit();}

    //jdk11为这些default函数提供了一些private函数
    private String doInit(){
        return null;
    }


}
