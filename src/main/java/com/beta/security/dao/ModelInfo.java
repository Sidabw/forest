package com.beta.security.dao;

import java.io.Serializable;
import java.util.Date;

public class ModelInfo implements Serializable {
    private Integer id;

    private Date gmtCreated;

    private Date gmtModified;

    private String pinyinMongoId;

    private String comment;

    private String pinyinAll;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPinyinMongoId() {
        return pinyinMongoId;
    }

    public void setPinyinMongoId(String pinyinMongoId) {
        this.pinyinMongoId = pinyinMongoId == null ? null : pinyinMongoId.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getPinyinAll() {
        return pinyinAll;
    }

    public void setPinyinAll(String pinyinAll) {
        this.pinyinAll = pinyinAll == null ? null : pinyinAll.trim();
    }
}