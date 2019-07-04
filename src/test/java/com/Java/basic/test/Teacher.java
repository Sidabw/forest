/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Teacher
 * Author:   feiyi
 * Date:     2019/7/2 11:29 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import com.alibaba.fastjson.JSONObject;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/2
 * @since 1.0.0
 */
public class Teacher<T> {

    private String name;

    private T course;

    public Teacher(String name, T course){
        this.name = name;
        this.course = course;
    }

    public String getInfo(){
        return name + JSONObject.toJSONString(course);
    }
}
