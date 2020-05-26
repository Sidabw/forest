/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Recursion
 * Author:   feiyi
 * Date:     2019/10/23 3:16 PM
 * Description: 递归练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.sort.merge;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈递归练习〉
 *
 * @author feiyi
 * @create 2019/10/23
 * @since 1.0.0
 */
public class Recursion {
    //单层递归
    @Test
    public void test1() {
        singleRecursion(5);
    }

    private void singleRecursion(int i) {
        if (i > 0) {
            System.out.println("+");
            singleRecursion(--i);
            singleRecursion(--i);
            System.out.println("=");
        }
    }

    //双层递归
    @Test
    public void test2(){
        int a = 2;
        int b = 2;
        System.out.println(a--);
        System.out.println(--b);

        int[] origin = new int[] {6, 202, 100, 301, 38, 8, 1};
        int aa = 8/10;
        System.out.println(aa);
    }

}
