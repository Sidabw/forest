/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Person Author:   shaogz Date:     2021/4/22 4:46 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/4/22
 * @since 1.0.0
 */
public class Person {

    private String f1;

    private int f2;

    private boolean f3;

    private Person2 person2;

    public Person(String f1, int f2, boolean f3, Person2 person2) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.person2 = person2;
    }

    public Person() {
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public int getF2() {
        return f2;
    }

    public void setF2(int f2) {
        this.f2 = f2;
    }

    public boolean isF3() {
        return f3;
    }

    public void setF3(boolean f3) {
        this.f3 = f3;
    }

    public Person2 getPerson2() {
        return person2;
    }

    public void setPerson2(Person2 person2) {
        this.person2 = person2;
    }
}
