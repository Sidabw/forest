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
        //这里写不写this都一样，访问的都是本类的属性
        return str;
    }

    public String getStr2() {
        //这里写不写this都一样, 访问的都是子类的m1方法
        //继承：方法覆盖、属性不覆盖
        return m1();
    }

    protected String m1() {
        return str;
    }
}
