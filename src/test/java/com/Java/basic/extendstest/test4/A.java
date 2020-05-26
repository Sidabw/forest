/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: A
 * Author:   feiyi
 * Date:     2020/1/6 4:30 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test4;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/1/6
 * @since 1.0.0
 */
public class A {

    protected static String staticStr = "a";

    protected String str = "a";

    public String getStaticStr(){
        return staticStr;
    }

    public String getStr() {
        return this.str;
    }

    public String getStr2() {
        return this.m1();
    }

    protected String m1() {
        return str;
    }
}
