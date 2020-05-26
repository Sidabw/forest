/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo2
 * Author:   feiyi
 * Date:     2020/4/26 1:58 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.personal.home;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/4/26
 * @since 1.0.0
 */
public class Demo2 {
    //年利率是3.25%,分10年还款与30年还款。等额本息，贷款100w。
    //按照每月收入9771.9来算，一直到30年。
    //即10年还款的，前10年是一份收益都没有的，一分不剩。
    //分30年还款的，每年有一部分可以用于理财。
    //10年还款的，到第11年，每年新近本金相比与30年还款的就要高了。
    //现在计算，到第31年上，哪种方式留下的钱更多。即，贷款，到底应该是按照最短年限来贷款，还是最高年限。

    @Test
    public void test(){
        double b1 = 0.04;//理财利率
        double b2 = 0.0325;//公积金贷款利率
        double incomeM = 9771.9;
        double expend10M = 9771.9;//10年还款的，每月支出。到第11年就是0了。
        double expend30M = 5307.27;//30年还款的，每月支出。

        double count10 = 0;
        double count30 = 0;
        for (int i = 0; i < 30; i++) {
            //一年的收入
            double income12 = BigDecimal.valueOf(incomeM).multiply(BigDecimal.valueOf(12)).doubleValue();
            //一年的支出：10年还款的
            double expend10 = 0;
            if (i < 10)
                expend10 = BigDecimal.valueOf(expend10M).multiply(BigDecimal.valueOf(12)).doubleValue();
            //一年的支出：30年还款的
            double expend30 = BigDecimal.valueOf(expend30M).multiply(BigDecimal.valueOf(12)).doubleValue();

            //一年的剩余：10年还款的
            double left10 = BigDecimal.valueOf(income12).subtract(BigDecimal.valueOf(expend10)).doubleValue();
            //一年的剩余：30年还款的
            double left30 = BigDecimal.valueOf(income12).subtract(BigDecimal.valueOf(expend30)).doubleValue();

            BigDecimal leftAll10Benjin = BigDecimal.valueOf(left10).add(BigDecimal.valueOf(count10));
            BigDecimal leftALl10Lixi = leftAll10Benjin.multiply(BigDecimal.valueOf(b1));
            BigDecimal leftAll10 = leftAll10Benjin.add(leftALl10Lixi);

            BigDecimal leftAll30Benjin = BigDecimal.valueOf(left30).add(BigDecimal.valueOf(count30));
            BigDecimal leftAll30Lixi = leftAll30Benjin.multiply(BigDecimal.valueOf(b1));
            BigDecimal leftAll30 = leftAll30Benjin.add(leftAll30Lixi);

            count10 = leftAll10.setScale(2, RoundingMode.HALF_UP).doubleValue();
            count30 = leftAll30.setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println("第" + (i + 1) + "年，10年剩余" + count10);
            System.out.println("第" + (i + 1) + "年，30年剩余" + count30);
        }



    }

}
