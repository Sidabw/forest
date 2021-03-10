/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2021/3/8 7:26 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kuaishou;

/**
 * 〈一句话功能简述〉:
 * 〈字符串压缩函数：例如输入abbbbccaa，压缩后的字符串为ab4c2a2（4为字母b连续出现的次数）〉
 *
 * @author feiyi
 * @create 2021/3/8
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) {
        char[] origin = "abbbbccaa".toCharArray();
        char[] res = new char[origin.length];
        char pre = origin[0];
        int repeatedNum = 0;
        int resIndex = 0;
        for (int i = 1; i < origin.length; i++) {
            char cur = origin[i];
            if (cur == pre) {
                repeatedNum++;
            }else {
                res[resIndex++] = pre;
                if (repeatedNum!=0) {
                    repeatedNum++;
                    res[resIndex++] = Integer.valueOf(repeatedNum).toString().charAt(0);
                    //重置
                    repeatedNum = 0;
                }
            }
            pre = cur;
            if (i == origin.length - 1) {
                res[resIndex++] = pre;
                if (repeatedNum!=0) {
                    repeatedNum++;
                    res[resIndex++] = Integer.valueOf(repeatedNum).toString().charAt(0);
                    //重置
                    repeatedNum = 0;
                }
            }
        }
        //输出res 0, resIndex-1
        for (int i=0;i < resIndex ; i++) {
            System.out.print(res[i]);
        }
    }

}
