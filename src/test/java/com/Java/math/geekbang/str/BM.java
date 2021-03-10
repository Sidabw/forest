/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: BMdemo
 * Author:   feiyi
 * Date:     2021/1/24 6:19 PM
 * Description: 字符串匹配算法BM的代码实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.geekbang.str;

/**
 * 〈一句话功能简述〉:
 * 〈字符串匹配算法BM的代码实现〉
 *
 * @author feiyi
 * @create 2021/1/24
 * @since 1.0.0
 */
public class BM {

    private static final int SIZE = 256;

    /**
     * @Description
     * @param b 模式串
     * @param m 模式串的长度
     * @param bc 模式串对应的散列表。用于坏字符存在于在模式串中的情况下，快速找到该坏字符在模式串中出现的位置。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2021/1/24 6:21 PM
     **/
    private void genBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            //初始化bc
            bc[i] = -1;
        }
        //将设a是坏字符。a的ascii计作a_ascii, 那么实际用的时候bc[a_ascii]得到的就是坏字符a在模式串中的角标
        for (int i = 0; i < m; i++) {
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
    }

    /**
     * @Description 只考虑坏字符规则的BM字符串匹配，且不考虑si - xi 得一个负数的情况
     * @param a 主串
     * @param n 主串的长度
     * @param b 模式串
     * @param m 模式串的长度
     * @return: int
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2021/1/25 9:50 AM
     **/
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        //构建坏字符哈希表
        genBC(a, n, bc);
        int i = 0;
        while (i <= n - m) {
            int j;
            //模式串倒着跟主串匹配
            for (j = m - 1; j >=0 ; j--) {
                if (a[i+j] != b[j]) {
                    //不匹配，此时j即坏字符，j对应的下标即si
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            //此时说明匹配失败，模式串要向右移动，对应的就是i的右移。
            //按照'坏字符'原则，向右移动 si - xi位

            //j是si，关键是xi的获取。 bc[(int)a[i+j]] 拆成两步
            //1. int tmp = (int)a[i+j] ，这里i+j是坏字符在主串的下标，a[i+j]自然就是坏字符的值；int强转，把该char类型的坏字符串转为ascii int值。
            //2. int xi = bc[tmp] 把该ascii给散列表，获取到xi的位置。
            i = i + (j - bc[(int)a[i+j]]);
        }
        return -1;
    }
}
