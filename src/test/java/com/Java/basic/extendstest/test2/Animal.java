/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Animal
 * Author:   feiyi
 * Date:     2019/12/5 3:01 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest.test2;

import java.lang.reflect.ParameterizedType;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/5
 * @since 1.0.0
 */
public class Animal<T> {

    private T t;

    public Animal(){
        System.out.println(getClass());
        System.out.println((ParameterizedType)getClass().getGenericSuperclass());

        System.out.println( (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
