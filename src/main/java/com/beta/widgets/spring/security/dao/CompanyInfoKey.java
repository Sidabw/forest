package com.beta.widgets.spring.security.dao;

import java.io.Serializable;

public class CompanyInfoKey implements Serializable {
    private Integer id;

    private String stockCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }
}