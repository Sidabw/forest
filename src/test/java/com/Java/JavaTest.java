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
}
