package com.Java.basic;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/***
 *  Created by shao.guangze on 2018/7/26
 */
public class BasicTest {

    public static void main(String[] args) throws ParseException {
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
        BasicTest demo = new BasicTest();
        demo.equals(new BasicTest());
        System.out.println("-----------------------------------");
        Object o = new BasicTest();
        BasicTest d = (BasicTest)o;
        System.out.println(d == o); //所以说强转之后还是原来的对象
        System.out.println("----------------------------------");
        System.out.println(String.format("task.%s", 1));
        System.out.println("---");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str222 = df.format(date);
        int a = Integer.parseInt(str222);
        if (a >= 0 && a <= 6) {
            System.out.println("凌晨");
        }
        if (a > 6 && a <= 12) {
            System.out.println("上午");
        }
        if (a > 12 && a <= 13) {
            System.out.println("中午");
        }
        if (a > 13 && a <= 18) {
            System.out.println("下午");
        }
        if (a > 18 && a <= 24) {
            System.out.println("晚上");
        }
        System.out.println("-----");
        int hour = 15;
        int min = 51;

        if ((hour >= 7 && hour <12) || (hour == 12 && min <=50)) {
            System.out.println(11111);
        }

        System.out.println("-----");
        String da = "2019/01/01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(da);
        System.out.println(parse.getTime());
    }

    @Test
    public void test(){
        //伪随机数；密码学安全随机数；真随机数
        //1。伪随机数：看着是随机的，但实际上有固定的生成规则
        //2。密码学安全随机数，也不是真正意义上的随机数，但是没有办法根据已有样本推测出下一个元素
        //3。真随机数：往往都是一些实际现象，如抛硬币等。对核裂变等要求的真正随机数，往往是非常复杂的。
        int i = new Random().nextInt(10);
        System.out.println(i);
    }

    //string 和 StringBuffer 在使用上的一点区别。不考虑字符缓冲区等内容
    @Test
    public void diffBetweenStr(){
        String a = null;
//        System.out.println(new StringBuffer(a).append("aaaa").toString()); //会抛异常
        System.out.println(new StringBuffer().append("aaa").append(a).toString());
        System.out.println(a + "aaa");
    }

    @Test
    public void assertTest(){
        //断言之所以本地测试会被启动是因为启动参数上加上了-ea ，即-enableassert
        assert(true);
    }


    //Test
    @Test
    public void geTest(){
        //泛型测试
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ge1(strings);
//        ge1(integers);
    }

    public static void ge1(List<String> strs) {
        strs.forEach(System.out::print);
    }

}
