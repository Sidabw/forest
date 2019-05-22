/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: SubwayCostMonthly
 * Author:   feiyi
 * Date:     2019/5/22 10:37 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.cal.bjSubway;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 〈一句话功能简述〉:
 * 〈计算一个月地铁出行费用，只算家到公司的费用。
 * 满100打8折，满150打5折〉
 *
 * @author feiyi
 * @create 2019/5/22
 * @since 1.0.0
 */
public class SubwayCostMonthly {

    //平均按照1个月22个工作日，即22次地铁出行计算
    private static final int workdayCount = 22;

    //不算折扣，每次出行的费用
    private static final double costFirstly = 7;

    private static final BigDecimal disCountFirstly = new BigDecimal(100);

    private static final BigDecimal disCountSecondly = new BigDecimal(150);

    private static final MathContext mc = new MathContext(5,RoundingMode.HALF_UP);

    private static final BigDecimal disCountFirstlyCost = new BigDecimal(costFirstly).multiply(new BigDecimal(0.8), mc);

    private static final BigDecimal disCountSecondlyCost = new BigDecimal(costFirstly).multiply(new BigDecimal(0.5), mc);


    public static void main(String[] args) {
        double cla = cla(costFirstly, 1);
        System.out.println(cla);
    }

    public static double cla(double costCount, int curDay) {
        double curDayCost;
        if (curDay > workdayCount) return costCount;
        if (new BigDecimal(costCount).compareTo(disCountFirstly) == -1) {
            //第零梯队
            curDayCost = new BigDecimal(costCount).add(new BigDecimal(costFirstly)).doubleValue();
        } else if (new BigDecimal(costCount).compareTo(disCountSecondly) == -1) {
            //第一梯队
            curDayCost = new BigDecimal(costCount).add(disCountFirstlyCost, mc).doubleValue();
        } else {
            //第二梯队
            curDayCost = new BigDecimal(costCount).add(disCountSecondlyCost, mc).doubleValue();
        }
        System.out.println(curDayCost);
        return cla(curDayCost, curDay + 1);
    }
}
