/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: Q1
 * Author:   feiyi
 * Date:     2021/3/4 9:14 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.huixiaoer;

import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2021/3/4
 * @since 1.0.0
 */
public class Q1 {

    public static void main(String[] args) {
        int[] origin = new int[]{9, 3, 2, 4, 5, 6, 1, 2, 7, 8};
        int[] res = splitByXXX(origin);
        System.out.println(JSONArray.toJSONString(res));
    }



    private static int[] splitByXXX(int[] origin) {
        int jiCount = 0;
        int ouCount = 0;
        for (int each : origin) {
            if (each % 2 == 0) {
                ouCount++;
            } else {
                jiCount++;
            }
        }
        if (jiCount == 0 || ouCount == 0) {
            return origin;
        }
        int[] left = new int[jiCount];
        int lIndex = 0;
        int[] right = new int[ouCount];
        int rIndex = 0;
        for (int each : origin) {
            if (each % 2 == 0) {
                right[rIndex++] = each;
            } else {
                left[lIndex++] = each;
            }
        }
        int[] res = new int[origin.length];
        int resIndex = 0;
        for (int j : left) {
            res[resIndex++] = j;
        }
        for(int j : right) {
            res[resIndex++] = j;
        }
        return res;
    }

}
