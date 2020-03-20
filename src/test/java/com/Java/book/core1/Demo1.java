/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo1
 * Author:   feiyi
 * Date:     2020/3/19 10:49 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.book.core1;

import org.junit.Test;


/**
 * 〈一句话功能简述〉:
 * 〈
 * 1。ascii
 *  0 48
 *  A 65
 *  a 97
 * 〉
 *
 * @author feiyi
 * @create 2020/3/19
 * @since 1.0.0
 */
public class Demo1 {

    @Test
    public void test () {
        int a = 0b110;//加上0b的前缀表示二进制
        int a1 = 0xf;   //加上0x的前缀表示十六进制
        System.out.println(a);
        System.out.println(a1);
        int a2 = 1_000_000;//只是为了更加易读：表示一百万，编译后会省略 _
        //浮点类型后面不跟F默认是D
        //char类型是用于表示Unicode编码的字符单元的字符类型
        char a3 = 'a';
        int a4 = a3 + 1;
        System.out.println(a4); //因为 'a'对应ascii码表的十进制值是97

    }
}
