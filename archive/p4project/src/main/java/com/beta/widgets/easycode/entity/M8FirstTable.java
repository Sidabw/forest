package com.beta.widgets.easycode.entity;

import java.io.Serializable;

/**
 * (M8FirstTable)实体类
 *
 * @author makejava
 * @since 2020-06-26 17:02:09
 */
public class M8FirstTable implements Serializable {
    private static final long serialVersionUID = 116701531279480165L;
    
    private Integer id;
    
    private Object phoneNums;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getPhoneNums() {
        return phoneNums;
    }

    public void setPhoneNums(Object phoneNums) {
        this.phoneNums = phoneNums;
    }

}