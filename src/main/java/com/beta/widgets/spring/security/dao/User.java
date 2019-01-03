package com.beta.widgets.spring.security.dao;

import java.io.Serializable;
import java.util.Date;

public class User extends UserKey implements Serializable {
    private String stockName;

    private String companyName;

    private String usedName;

    private String transactionCurrency;

    private String stockClasses;

    private String ipoDate;

    private String listingLocation;

    private String stockCodeB;

    private String stockNameB;

    private String stockCodeH;

    private String stockNameH;

    private String securityPlate;

    private String industryCategory1;

    private String industryCategory2;

    private String industryCategory3;

    private String province;

    private String city;

    private String registeredAddress;

    private String officeAddress;

    private String realityControler;

    private String finalControler;

    private String establishmentDate;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName == null ? null : usedName.trim();
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency == null ? null : transactionCurrency.trim();
    }

    public String getStockClasses() {
        return stockClasses;
    }

    public void setStockClasses(String stockClasses) {
        this.stockClasses = stockClasses == null ? null : stockClasses.trim();
    }

    public String getIpoDate() {
        return ipoDate;
    }

    public void setIpoDate(String ipoDate) {
        this.ipoDate = ipoDate == null ? null : ipoDate.trim();
    }

    public String getListingLocation() {
        return listingLocation;
    }

    public void setListingLocation(String listingLocation) {
        this.listingLocation = listingLocation == null ? null : listingLocation.trim();
    }

    public String getStockCodeB() {
        return stockCodeB;
    }

    public void setStockCodeB(String stockCodeB) {
        this.stockCodeB = stockCodeB == null ? null : stockCodeB.trim();
    }

    public String getStockNameB() {
        return stockNameB;
    }

    public void setStockNameB(String stockNameB) {
        this.stockNameB = stockNameB == null ? null : stockNameB.trim();
    }

    public String getStockCodeH() {
        return stockCodeH;
    }

    public void setStockCodeH(String stockCodeH) {
        this.stockCodeH = stockCodeH == null ? null : stockCodeH.trim();
    }

    public String getStockNameH() {
        return stockNameH;
    }

    public void setStockNameH(String stockNameH) {
        this.stockNameH = stockNameH == null ? null : stockNameH.trim();
    }

    public String getSecurityPlate() {
        return securityPlate;
    }

    public void setSecurityPlate(String securityPlate) {
        this.securityPlate = securityPlate == null ? null : securityPlate.trim();
    }

    public String getIndustryCategory1() {
        return industryCategory1;
    }

    public void setIndustryCategory1(String industryCategory1) {
        this.industryCategory1 = industryCategory1 == null ? null : industryCategory1.trim();
    }

    public String getIndustryCategory2() {
        return industryCategory2;
    }

    public void setIndustryCategory2(String industryCategory2) {
        this.industryCategory2 = industryCategory2 == null ? null : industryCategory2.trim();
    }

    public String getIndustryCategory3() {
        return industryCategory3;
    }

    public void setIndustryCategory3(String industryCategory3) {
        this.industryCategory3 = industryCategory3 == null ? null : industryCategory3.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress == null ? null : registeredAddress.trim();
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress == null ? null : officeAddress.trim();
    }

    public String getRealityControler() {
        return realityControler;
    }

    public void setRealityControler(String realityControler) {
        this.realityControler = realityControler == null ? null : realityControler.trim();
    }

    public String getFinalControler() {
        return finalControler;
    }

    public void setFinalControler(String finalControler) {
        this.finalControler = finalControler == null ? null : finalControler.trim();
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate == null ? null : establishmentDate.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}