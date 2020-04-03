/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/12/4 7:38 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.personal.home;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/4
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void test () {
        int years = 30; //年限
        int money = 20000;  //每年存多少钱
        int end = 5;    //连续存几年
        double b1 = 0.0244; //余额宝年利率

        double moneyCount = 0.0;
        for (int i = 0 ; i < 30 ; i++) {
            end --;
            if (end >= 0) {
                moneyCount += BigDecimal.valueOf(money).doubleValue();
            }
            BigDecimal lixi = BigDecimal.valueOf(b1).multiply(BigDecimal.valueOf(moneyCount));
            moneyCount = BigDecimal.valueOf(moneyCount).add(lixi).doubleValue();
        }
        System.out.println(moneyCount);
    }
}
