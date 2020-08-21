/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: AbstractTest
 * Author:   feiyi
 * Date:     2019/12/23 5:52 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test3;

import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/23
 * @since 1.0.0
 */
public class AbstractTest {

    @Test
    public void test() {

        //证明创建一个继承抽象类的匿名内部类时，必须复写父类的所有抽象方法。
        new A() {

            @Override
            void aM1() {

            }

            @Override
            void aM2() {

            }
        };
    }
}
