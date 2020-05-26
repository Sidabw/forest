/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/5/15 3:20 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.javamath;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈BigDecimal 商业小数计算使用〉
 *
 * @author feiyi
 * @create 2019/5/15
 * @since 1.0.0
 */
public class DecimalTest {

    //BigDecimal正确错误示例
    @Test
    public void test1(){
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
        //计算准确：得116.2
        System.out.println(bigDecimal1.add(bigDecimal2.multiply(bigDecimal)).doubleValue());

        BigDecimal bigDecimal222 = new BigDecimal(0.8);
        BigDecimal bigDecimal22 =  new BigDecimal(7);
        BigDecimal bigDecimal21 =  new BigDecimal(110.6);
        //计算不正确：得116.19999999999999
        System.out.println(bigDecimal21.add(bigDecimal22.multiply(bigDecimal222)).doubleValue());
    }

    //基本使用BigDecimal
    @Test
    public void test2() {
        //The BigDecimal class gives its user complete control over rounding behavior. If no rounding mode is specified
        // and the exact result cannot be represented, an exception is thrown;
        //如果没指定舍入模式且无法表示准确结果，那就抛异常。
        //实际进去的是一个char数组，小数点前的和小数点后的分开计算

        //创建BigDecimal的两种推荐方式
        BigDecimal decimal1 = new BigDecimal("0.1");
        BigDecimal decimal2 = BigDecimal.valueOf(0.2);
        //加减乘除
        System.out.println(decimal1.add(decimal2).doubleValue());     //加
        System.out.println(decimal1.subtract(decimal2));//减
        System.out.println(decimal1.multiply(decimal2));//乘
        System.out.println(decimal1.divide(decimal2));  //除
    }

    //使用HALF_UP实现四舍五入
    @Test
    public void test3(){
        //四舍五入：使用BigDecimal处理小数点精度问题
//        BigDecimal b1 = BigDecimal.valueOf(1.234);
//        BigDecimal b1 = BigDecimal.valueOf(1.235);
        BigDecimal b1 = BigDecimal.valueOf(1.233);
        BigDecimal b2 = BigDecimal.valueOf(0.001);
        BigDecimal result = b1.add(b2);

        BigDecimal result2Print = result.setScale(2, RoundingMode.HALF_UP);
        System.out.println(result2Print.doubleValue());
    }

    //DecimalFormat使用
    //占位符可以使用0和#两种，当使用0的时候会严格按照样式来进行匹配，不够的时候会补0，而使用#时会将前后的0进行忽略
    //正常的舍入操作直接使用BigDecimal的setScale
    @Test
    public void test4(){
        double ll = 0.55123 ;
        DecimalFormat d1 = new DecimalFormat("0.00000000");
        DecimalFormat d2 = new DecimalFormat("#.########");
        DecimalFormat d3 = new DecimalFormat("0.00%");  //format传入浮点返回正确的xx%
        d1.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(d1.format(ll));
        System.out.println(d2.format(ll));
        System.out.println(d3.format(ll));
    }

    //Math使用
    @Test
    public void test5 (){
        //Math取整Math.round四舍五入取整
        System.out.println(Math.floor(5.4));
        System.out.println(Math.floor(5.5));
        System.out.println(Math.floor(5.6));
        System.out.println(Math.floor(6.4));
        System.out.println(Math.floor(6.5));
        System.out.println(Math.floor(6.6));

        System.out.println(Math.round(5.4));
        System.out.println(Math.round(5.5));
        System.out.println(Math.round(5.6));
        System.out.println(Math.round(6.4));
        System.out.println(Math.round(6.5));
        System.out.println(Math.round(6.6));
    }

}
