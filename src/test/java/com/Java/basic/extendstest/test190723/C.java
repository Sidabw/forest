/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: C
 * Author:   feiyi
 * Date:     2019/7/23 3:53 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test190723;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/23
 * @since 1.0.0
 */
public class C {

    public static void main(String[] args){
        B<C> cb = new B<>();
        C c = cb.get();
    }
}