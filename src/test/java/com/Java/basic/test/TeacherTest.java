/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: TeacherTest
 * Author:   feiyi
 * Date:     2019/7/2 11:32 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/2
 * @since 1.0.0
 */
public class TeacherTest {

    @Test
    public void test1(){
        List<String> strs = Arrays.asList("1", "2", "3");
        Teacher<List<String>> zhangsan = new Teacher<>("zhangsan", strs);
        System.out.println(zhangsan.getInfo());
    }
}
