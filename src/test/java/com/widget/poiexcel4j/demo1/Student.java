/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Student
 * Author:   feiyi
 * Date:     2019/4/15 10:37 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.poiexcel4j.demo1;

import com.github.crab2died.annotation.ExcelField;

import java.util.Date;


/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/15
 * @since 1.0.0
 */
public class Student {

    @ExcelField(title = "学号", order = 1)
    private Long id;

    @ExcelField(title = "姓名", order = 2)
    private String name;

    //读数据转换器
    @ExcelField(title = "入学日期", order = 3, readConverter = Student2DateConverter.class)
    private Date date;

    @ExcelField(title = "班级", order = 4)
    private Integer classes;

    //写数据转换器
    @ExcelField(title = "是否开除", order = 5, writeConverter = Student2ExpelConverter.class)
    private boolean expel;

    public Student(long l, String s, Date date, int i, boolean b) {
        this.id = l;
        this.name = s;
        this.date = date;
        this.classes = i;
        this.expel = b;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public boolean isExpel() {
        return expel;
    }

    public void setExpel(boolean expel) {
        this.expel = expel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", classes=" + classes +
                ", expel=" + expel +
                '}';
    }
}
