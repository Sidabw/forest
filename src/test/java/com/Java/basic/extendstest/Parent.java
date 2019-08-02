/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Parent
 * Author:   feiyi
 * Date:     2018/12/6 上午10:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.extendstest;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/6
 * @since 1.0.0
 */
public class Parent {

    private String testt = "2";

    Parent(){
        System.out.println(this.testt);
    }
    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

