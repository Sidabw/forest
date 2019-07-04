/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: JavaTest
 * Author:   feiyi
 * Date:     2019/4/21 9:54 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/21
 * @since 1.0.0
 */
public class JavaTest {

    @Test
    public void test(){
        //四舍六入 五奇偶...  最后也没搞明白
        double ll = 0.559 ;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String format = decimalFormat.format(ll);
        System.out.println(format);
        System.out.println(Double.parseDouble(format));
        System.out.println("---");
    }

    @Test
    public void test2(){
//为什么二进制不能表示一个小数，举例0.1换成二进制，请看下面的运算
//        0.1 * 2 = 0.2     -----0
//        0.2 * 2 = 0.4     -----0
//        0.4 * 2 = 0.8     -----0
//        0.8 * 2 = 1.6     -----1
//        0.6 * 2 = 1.2     -----1
//        0.2 * 2 = 0.4     -----0
//你懂的 0.0001100110011001100110011001100110011001100110011001101
        BigDecimal bigDecimal = BigDecimal.valueOf(0.8);
        BigDecimal bigDecimal2 =  BigDecimal.valueOf(7);
        BigDecimal bigDecimal1 =  BigDecimal.valueOf(110.6);
        System.out.println(bigDecimal1.add(bigDecimal2.multiply(bigDecimal)).doubleValue());

        BigDecimal bigDecimal222 = new BigDecimal(0.8);
        BigDecimal bigDecimal22 =  new BigDecimal(7);
        BigDecimal bigDecimal21 =  new BigDecimal(110.6);
        System.out.println(bigDecimal21.add(bigDecimal22.multiply(bigDecimal222)).doubleValue());

    }

    @Test
    public void test3(){
//        double rd = Math.random();
//        System.out.println(rd);
//        String rdStr = String.format("%." + (3 - 1) + "f", rd).replace("0.", "") + (int)(Math.random() * 10.0D) % 10;
//        System.out.println(rdStr);
//        System.out.println("---");
//        System.out.println(String.format("%.2f", 0.444));
        JavaTest javaTest = new JavaTest();
        while (true){
            String result = javaTest.randomTest(3);
            if (result.contains("\\.")) {
                System.out.println(result);
                break;
            }
        }
    }

    public String randomTest(int digit){
        double rd = Math.random();
        String rdStr = String.format("%." + (digit - 1) + "f", rd).replace("0.", "") + (int)(Math.random() * 10.0D) % 10;
        return rdStr;
    }

    @Test
    public void test4(){
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
    }

    @Test
    public void test5(){

    }
}
