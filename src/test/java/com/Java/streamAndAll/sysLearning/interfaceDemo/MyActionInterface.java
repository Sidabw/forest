package com.Java.streamAndAll.sysLearning.interfaceDemo;

/**
 * @author  Brew
 * */
@FunctionalInterface
public interface MyActionInterface {
	 public void saySomeThing(String str);
	    /**
	     * Java8引入的新特性 接口中可以定义一个或多个default方法的实现 (不是abstract)
	     */
	    default void say(){
	        System.out.println("default say");
	    }

        default void say2(){
        System.out.println("default say2");
    }
}
