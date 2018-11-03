package com.stringtetst.test;

/***
 *  Created by shao.guangze on 2018/7/26
 */
public class Demo {
    public static void main(String[] args){
        String str = "Ddabcdefghijklmnopqrst";
        System.out.println(str.indexOf("def"));
        String str2 = "aa\\aba\"";
        str2 = str2.replaceAll("\\\\","\\\\\\\\");  //1个反斜线换成2个反斜线
        str2 = str2.replaceAll("\"","\\\\\"");  //1个单引号变成1个反斜杠+1个单引号
        str2 = str2.replaceAll("b","\\\\"); //同样，1个反斜杠需要用4个反斜杠来表示
        System.out.println(str2);
        System.out.println("----------------------------------");
        String str3 = "我爱吃萝卜头啊啊";
        System.out.println(str3.length());
        System.out.println(str3.substring(0,8));
        System.out.println(str3.substring(8).equals(""));
        System.out.println("----------------------------------");
        System.out.println(null instanceof String);
        System.out.println(new Double(Double.valueOf("0.1")*1000).intValue());
        String aaa = new String("aaa");
        String aaa1 = new String("aaa");
        System.out.println(aaa.hashCode() == aaa1.hashCode());
        System.out.println(aaa.equals(aaa1));
        Demo demo = new Demo();
        demo.equals(new Demo());
    }
}
