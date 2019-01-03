package com.beta.widgets.spring.security.dao;

import java.io.Serializable;

public class SecuritiesProductInfo implements Serializable {
    private Long id;

    private String gmt8Created;

    private String gmt8Modified;

    private Byte isDelete;

    private String code;

    private String name;

    private String hisNames;

    private Long cateId;

    private String cateName;

    private String attrTags;

    private String companyName;

    private String transactionCurrency;

    private String ipoDate;

    private String extraInfo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmt8Created() {
        return gmt8Created;
    }

    public void setGmt8Created(String gmt8Created) {
        this.gmt8Created = gmt8Created == null ? null : gmt8Created.trim();
    }

    public String getGmt8Modified() {
        return gmt8Modified;
    }

    public void setGmt8Modified(String gmt8Modified) {
        this.gmt8Modified = gmt8Modified == null ? null : gmt8Modified.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHisNames() {
        return hisNames;
    }

    public void setHisNames(String hisNames) {
        this.hisNames = hisNames == null ? null : hisNames.trim();
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public String getAttrTags() {
        return attrTags;
    }

    public void setAttrTags(String attrTags) {
        this.attrTags = attrTags == null ? null : attrTags.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency == null ? null : transactionCurrency.trim();
    }

    public String getIpoDate() {
        return ipoDate;
    }

    public void setIpoDate(String ipoDate) {
        this.ipoDate = ipoDate == null ? null : ipoDate.trim();
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }
}