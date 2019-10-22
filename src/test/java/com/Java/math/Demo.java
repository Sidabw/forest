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
package com.Java.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
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
public class Demo {

    public static void main(String[] args) {
        //创建BigDecimal的两种推荐方式
        BigDecimal decimal1 = new BigDecimal("0.1");
        BigDecimal decimal2 = BigDecimal.valueOf(0.2);
        //加减乘除
        System.out.println(decimal1.add(decimal2).doubleValue());     //加
        System.out.println(decimal1.subtract(decimal2));//减
        System.out.println(decimal1.multiply(decimal2));//乘
        System.out.println(decimal1.divide(decimal2));  //除

        //The BigDecimal class gives its user complete control over rounding behavior. If no rounding mode is specified
        // and the exact result cannot be represented, an exception is thrown;
        //如果没指定舍入模式且无法表示准确结果，那就抛异常。
        //实际进去的是一个char数组，小数点前的和小数点后的分开计算

        System.out.println("-----");
//        new BigInteger()

//        BigInteger bigInteger = new BigInteger("{");
//        System.out.println(bigInteger);
    }

}
