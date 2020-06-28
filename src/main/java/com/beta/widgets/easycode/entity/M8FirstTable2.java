package com.beta.widgets.easycode.entity;

import java.io.Serializable;

/**
 * (M8FirstTable2)实体类
 *
 * @author makejava
 * @since 2020-06-26 17:33:50
 */
public class M8FirstTable2 implements Serializable {
    private static final long serialVersionUID = -10341473948595643L;
    
    private Integer id;
    
    private String phonenum;
    
    private String soHot;
    
    private String phoneNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getSoHot() {
        return soHot;
    }

    public void setSoHot(String soHot) {
        this.soHot = soHot;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}