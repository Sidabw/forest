/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/5/24 10:17 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.cal.danke;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/5/24
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void test(){
        int a = 2230;
        BigDecimal bigDecimalA = BigDecimal.valueOf(a);
        BigDecimal bigDecimalB = BigDecimal.valueOf(2.5);
        BigDecimal bigDecimalC = BigDecimal.valueOf(12);
        BigDecimal multiply = bigDecimalA.multiply(bigDecimalC); // a * 12
        BigDecimal multiply1 = bigDecimalA.multiply(bigDecimalB);   //a * 2.5
        BigDecimal subtract = multiply.subtract(multiply1); //(a * 12) - (a*2.5)
        double end = subtract.divide(bigDecimalC,0, RoundingMode.HALF_DOWN).doubleValue();
        System.out.println(end);
    }
}
