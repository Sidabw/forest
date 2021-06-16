/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Demo Author:   shaogz Date:     2021/6/1 1:44 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.personal.cal.sida;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/6/1
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) {

        //求四位数，已知前两位相同、后两位相同（xxyy），且该四位数是某个数的平方
        LinkedList<String> result = new LinkedList<>();
        int x = 0;
        int tmp = x * x;
        //只有tmp是2位数或4位数才满足条件
        while (tmp <= 9999) {
            String tmpStr = Integer.toString(tmp);
            char[] chars = tmpStr.toCharArray();
            if (chars.length == 2 && chars[0] == chars[1]) {
                result.add(tmpStr);
            } else if (chars.length == 4 && chars[0] == chars[1] && chars[2] == chars[3]) {
                result.add(tmpStr);
            }
            x++;
            tmp = x * x;
        }
        //print result
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
