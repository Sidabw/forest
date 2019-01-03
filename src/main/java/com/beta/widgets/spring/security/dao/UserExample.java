package com.beta.widgets.spring.security.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNull() {
            addCriterion("stock_name is null");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNotNull() {
            addCriterion("stock_name is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameEqualTo(String value) {
            addCriterion("stock_name =", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotEqualTo(String value) {
            addCriterion("stock_name <>", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThan(String value) {
            addCriterion("stock_name >", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThanOrEqualTo(String value) {
            addCriterion("stock_name >=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThan(String value) {
            addCriterion("stock_name <", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThanOrEqualTo(String value) {
            addCriterion("stock_name <=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLike(String value) {
            addCriterion("stock_name like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotLike(String value) {
            addCriterion("stock_name not like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameIn(List<String> values) {
            addCriterion("stock_name in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotIn(List<String> values) {
            addCriterion("stock_name not in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameBetween(String value1, String value2) {
            addCriterion("stock_name between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotBetween(String value1, String value2) {
            addCriterion("stock_name not between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andUsedNameIsNull() {
            addCriterion("used_name is null");
            return (Criteria) this;
        }

        public Criteria andUsedNameIsNotNull() {
            addCriterion("used_name is not null");
            return (Criteria) this;
        }

        public Criteria andUsedNameEqualTo(String value) {
            addCriterion("used_name =", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotEqualTo(String value) {
            addCriterion("used_name <>", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameGreaterThan(String value) {
            addCriterion("used_name >", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameGreaterThanOrEqualTo(String value) {
            addCriterion("used_name >=", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameLessThan(String value) {
            addCriterion("used_name <", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameLessThanOrEqualTo(String value) {
            addCriterion("used_name <=", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameLike(String value) {
            addCriterion("used_name like", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotLike(String value) {
            addCriterion("used_name not like", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameIn(List<String> values) {
            addCriterion("used_name in", values, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotIn(List<String> values) {
            addCriterion("used_name not in", values, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameBetween(String value1, String value2) {
            addCriterion("used_name between", value1, value2, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotBetween(String value1, String value2) {
            addCriterion("used_name not between", value1, value2, "usedName");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyIsNull() {
            addCriterion("transaction_currency is null");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyIsNotNull() {
            addCriterion("transaction_currency is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyEqualTo(String value) {
            addCriterion("transaction_currency =", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyNotEqualTo(String value) {
            addCriterion("transaction_currency <>", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyGreaterThan(String value) {
            addCriterion("transaction_currency >", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_currency >=", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyLessThan(String value) {
            addCriterion("transaction_currency <", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyLessThanOrEqualTo(String value) {
            addCriterion("transaction_currency <=", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyLike(String value) {
            addCriterion("transaction_currency like", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyNotLike(String value) {
            addCriterion("transaction_currency not like", value, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyIn(List<String> values) {
            addCriterion("transaction_currency in", values, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyNotIn(List<String> values) {
            addCriterion("transaction_currency not in", values, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyBetween(String value1, String value2) {
            addCriterion("transaction_currency between", value1, value2, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andTransactionCurrencyNotBetween(String value1, String value2) {
            addCriterion("transaction_currency not between", value1, value2, "transactionCurrency");
            return (Criteria) this;
        }

        public Criteria andStockClassesIsNull() {
            addCriterion("stock_classes is null");
            return (Criteria) this;
        }

        public Criteria andStockClassesIsNotNull() {
            addCriterion("stock_classes is not null");
            return (Criteria) this;
        }

        public Criteria andStockClassesEqualTo(String value) {
            addCriterion("stock_classes =", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesNotEqualTo(String value) {
            addCriterion("stock_classes <>", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesGreaterThan(String value) {
            addCriterion("stock_classes >", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesGreaterThanOrEqualTo(String value) {
            addCriterion("stock_classes >=", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesLessThan(String value) {
            addCriterion("stock_classes <", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesLessThanOrEqualTo(String value) {
            addCriterion("stock_classes <=", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesLike(String value) {
            addCriterion("stock_classes like", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesNotLike(String value) {
            addCriterion("stock_classes not like", value, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesIn(List<String> values) {
            addCriterion("stock_classes in", values, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesNotIn(List<String> values) {
            addCriterion("stock_classes not in", values, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesBetween(String value1, String value2) {
            addCriterion("stock_classes between", value1, value2, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andStockClassesNotBetween(String value1, String value2) {
            addCriterion("stock_classes not between", value1, value2, "stockClasses");
            return (Criteria) this;
        }

        public Criteria andIpoDateIsNull() {
            addCriterion("ipo_date is null");
            return (Criteria) this;
        }

        public Criteria andIpoDateIsNotNull() {
            addCriterion("ipo_date is not null");
            return (Criteria) this;
        }

        public Criteria andIpoDateEqualTo(String value) {
            addCriterion("ipo_date =", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateNotEqualTo(String value) {
            addCriterion("ipo_date <>", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateGreaterThan(String value) {
            addCriterion("ipo_date >", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateGreaterThanOrEqualTo(String value) {
            addCriterion("ipo_date >=", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateLessThan(String value) {
            addCriterion("ipo_date <", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateLessThanOrEqualTo(String value) {
            addCriterion("ipo_date <=", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateLike(String value) {
            addCriterion("ipo_date like", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateNotLike(String value) {
            addCriterion("ipo_date not like", value, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateIn(List<String> values) {
            addCriterion("ipo_date in", values, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateNotIn(List<String> values) {
            addCriterion("ipo_date not in", values, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateBetween(String value1, String value2) {
            addCriterion("ipo_date between", value1, value2, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andIpoDateNotBetween(String value1, String value2) {
            addCriterion("ipo_date not between", value1, value2, "ipoDate");
            return (Criteria) this;
        }

        public Criteria andListingLocationIsNull() {
            addCriterion("listing_location is null");
            return (Criteria) this;
        }

        public Criteria andListingLocationIsNotNull() {
            addCriterion("listing_location is not null");
            return (Criteria) this;
        }

        public Criteria andListingLocationEqualTo(String value) {
            addCriterion("listing_location =", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationNotEqualTo(String value) {
            addCriterion("listing_location <>", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationGreaterThan(String value) {
            addCriterion("listing_location >", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationGreaterThanOrEqualTo(String value) {
            addCriterion("listing_location >=", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationLessThan(String value) {
            addCriterion("listing_location <", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationLessThanOrEqualTo(String value) {
            addCriterion("listing_location <=", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationLike(String value) {
            addCriterion("listing_location like", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationNotLike(String value) {
            addCriterion("listing_location not like", value, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationIn(List<String> values) {
            addCriterion("listing_location in", values, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationNotIn(List<String> values) {
            addCriterion("listing_location not in", values, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationBetween(String value1, String value2) {
            addCriterion("listing_location between", value1, value2, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andListingLocationNotBetween(String value1, String value2) {
            addCriterion("listing_location not between", value1, value2, "listingLocation");
            return (Criteria) this;
        }

        public Criteria andStockCodeBIsNull() {
            addCriterion("stock_code_b is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeBIsNotNull() {
            addCriterion("stock_code_b is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeBEqualTo(String value) {
            addCriterion("stock_code_b =", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBNotEqualTo(String value) {
            addCriterion("stock_code_b <>", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBGreaterThan(String value) {
            addCriterion("stock_code_b >", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code_b >=", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBLessThan(String value) {
            addCriterion("stock_code_b <", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBLessThanOrEqualTo(String value) {
            addCriterion("stock_code_b <=", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBLike(String value) {
            addCriterion("stock_code_b like", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBNotLike(String value) {
            addCriterion("stock_code_b not like", value, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBIn(List<String> values) {
            addCriterion("stock_code_b in", values, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBNotIn(List<String> values) {
            addCriterion("stock_code_b not in", values, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBBetween(String value1, String value2) {
            addCriterion("stock_code_b between", value1, value2, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockCodeBNotBetween(String value1, String value2) {
            addCriterion("stock_code_b not between", value1, value2, "stockCodeB");
            return (Criteria) this;
        }

        public Criteria andStockNameBIsNull() {
            addCriterion("stock_name_b is null");
            return (Criteria) this;
        }

        public Criteria andStockNameBIsNotNull() {
            addCriterion("stock_name_b is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameBEqualTo(String value) {
            addCriterion("stock_name_b =", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBNotEqualTo(String value) {
            addCriterion("stock_name_b <>", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBGreaterThan(String value) {
            addCriterion("stock_name_b >", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBGreaterThanOrEqualTo(String value) {
            addCriterion("stock_name_b >=", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBLessThan(String value) {
            addCriterion("stock_name_b <", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBLessThanOrEqualTo(String value) {
            addCriterion("stock_name_b <=", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBLike(String value) {
            addCriterion("stock_name_b like", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBNotLike(String value) {
            addCriterion("stock_name_b not like", value, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBIn(List<String> values) {
            addCriterion("stock_name_b in", values, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBNotIn(List<String> values) {
            addCriterion("stock_name_b not in", values, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBBetween(String value1, String value2) {
            addCriterion("stock_name_b between", value1, value2, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockNameBNotBetween(String value1, String value2) {
            addCriterion("stock_name_b not between", value1, value2, "stockNameB");
            return (Criteria) this;
        }

        public Criteria andStockCodeHIsNull() {
            addCriterion("stock_code_h is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeHIsNotNull() {
            addCriterion("stock_code_h is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeHEqualTo(String value) {
            addCriterion("stock_code_h =", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHNotEqualTo(String value) {
            addCriterion("stock_code_h <>", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHGreaterThan(String value) {
            addCriterion("stock_code_h >", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code_h >=", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHLessThan(String value) {
            addCriterion("stock_code_h <", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHLessThanOrEqualTo(String value) {
            addCriterion("stock_code_h <=", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHLike(String value) {
            addCriterion("stock_code_h like", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHNotLike(String value) {
            addCriterion("stock_code_h not like", value, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHIn(List<String> values) {
            addCriterion("stock_code_h in", values, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHNotIn(List<String> values) {
            addCriterion("stock_code_h not in", values, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHBetween(String value1, String value2) {
            addCriterion("stock_code_h between", value1, value2, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockCodeHNotBetween(String value1, String value2) {
            addCriterion("stock_code_h not between", value1, value2, "stockCodeH");
            return (Criteria) this;
        }

        public Criteria andStockNameHIsNull() {
            addCriterion("stock_name_h is null");
            return (Criteria) this;
        }

        public Criteria andStockNameHIsNotNull() {
            addCriterion("stock_name_h is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameHEqualTo(String value) {
            addCriterion("stock_name_h =", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHNotEqualTo(String value) {
            addCriterion("stock_name_h <>", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHGreaterThan(String value) {
            addCriterion("stock_name_h >", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHGreaterThanOrEqualTo(String value) {
            addCriterion("stock_name_h >=", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHLessThan(String value) {
            addCriterion("stock_name_h <", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHLessThanOrEqualTo(String value) {
            addCriterion("stock_name_h <=", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHLike(String value) {
            addCriterion("stock_name_h like", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHNotLike(String value) {
            addCriterion("stock_name_h not like", value, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHIn(List<String> values) {
            addCriterion("stock_name_h in", values, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHNotIn(List<String> values) {
            addCriterion("stock_name_h not in", values, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHBetween(String value1, String value2) {
            addCriterion("stock_name_h between", value1, value2, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andStockNameHNotBetween(String value1, String value2) {
            addCriterion("stock_name_h not between", value1, value2, "stockNameH");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateIsNull() {
            addCriterion("security_plate is null");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateIsNotNull() {
            addCriterion("security_plate is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateEqualTo(String value) {
            addCriterion("security_plate =", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateNotEqualTo(String value) {
            addCriterion("security_plate <>", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateGreaterThan(String value) {
            addCriterion("security_plate >", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateGreaterThanOrEqualTo(String value) {
            addCriterion("security_plate >=", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateLessThan(String value) {
            addCriterion("security_plate <", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateLessThanOrEqualTo(String value) {
            addCriterion("security_plate <=", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateLike(String value) {
            addCriterion("security_plate like", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateNotLike(String value) {
            addCriterion("security_plate not like", value, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateIn(List<String> values) {
            addCriterion("security_plate in", values, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateNotIn(List<String> values) {
            addCriterion("security_plate not in", values, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateBetween(String value1, String value2) {
            addCriterion("security_plate between", value1, value2, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andSecurityPlateNotBetween(String value1, String value2) {
            addCriterion("security_plate not between", value1, value2, "securityPlate");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1IsNull() {
            addCriterion("industry_category1 is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1IsNotNull() {
            addCriterion("industry_category1 is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1EqualTo(String value) {
            addCriterion("industry_category1 =", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1NotEqualTo(String value) {
            addCriterion("industry_category1 <>", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1GreaterThan(String value) {
            addCriterion("industry_category1 >", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1GreaterThanOrEqualTo(String value) {
            addCriterion("industry_category1 >=", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1LessThan(String value) {
            addCriterion("industry_category1 <", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1LessThanOrEqualTo(String value) {
            addCriterion("industry_category1 <=", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1Like(String value) {
            addCriterion("industry_category1 like", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1NotLike(String value) {
            addCriterion("industry_category1 not like", value, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1In(List<String> values) {
            addCriterion("industry_category1 in", values, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1NotIn(List<String> values) {
            addCriterion("industry_category1 not in", values, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1Between(String value1, String value2) {
            addCriterion("industry_category1 between", value1, value2, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory1NotBetween(String value1, String value2) {
            addCriterion("industry_category1 not between", value1, value2, "industryCategory1");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2IsNull() {
            addCriterion("industry_category2 is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2IsNotNull() {
            addCriterion("industry_category2 is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2EqualTo(String value) {
            addCriterion("industry_category2 =", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2NotEqualTo(String value) {
            addCriterion("industry_category2 <>", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2GreaterThan(String value) {
            addCriterion("industry_category2 >", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2GreaterThanOrEqualTo(String value) {
            addCriterion("industry_category2 >=", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2LessThan(String value) {
            addCriterion("industry_category2 <", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2LessThanOrEqualTo(String value) {
            addCriterion("industry_category2 <=", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2Like(String value) {
            addCriterion("industry_category2 like", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2NotLike(String value) {
            addCriterion("industry_category2 not like", value, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2In(List<String> values) {
            addCriterion("industry_category2 in", values, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2NotIn(List<String> values) {
            addCriterion("industry_category2 not in", values, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2Between(String value1, String value2) {
            addCriterion("industry_category2 between", value1, value2, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory2NotBetween(String value1, String value2) {
            addCriterion("industry_category2 not between", value1, value2, "industryCategory2");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3IsNull() {
            addCriterion("industry_category3 is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3IsNotNull() {
            addCriterion("industry_category3 is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3EqualTo(String value) {
            addCriterion("industry_category3 =", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3NotEqualTo(String value) {
            addCriterion("industry_category3 <>", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3GreaterThan(String value) {
            addCriterion("industry_category3 >", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3GreaterThanOrEqualTo(String value) {
            addCriterion("industry_category3 >=", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3LessThan(String value) {
            addCriterion("industry_category3 <", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3LessThanOrEqualTo(String value) {
            addCriterion("industry_category3 <=", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3Like(String value) {
            addCriterion("industry_category3 like", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3NotLike(String value) {
            addCriterion("industry_category3 not like", value, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3In(List<String> values) {
            addCriterion("industry_category3 in", values, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3NotIn(List<String> values) {
            addCriterion("industry_category3 not in", values, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3Between(String value1, String value2) {
            addCriterion("industry_category3 between", value1, value2, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andIndustryCategory3NotBetween(String value1, String value2) {
            addCriterion("industry_category3 not between", value1, value2, "industryCategory3");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNull() {
            addCriterion("registered_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNotNull() {
            addCriterion("registered_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressEqualTo(String value) {
            addCriterion("registered_address =", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotEqualTo(String value) {
            addCriterion("registered_address <>", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThan(String value) {
            addCriterion("registered_address >", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThanOrEqualTo(String value) {
            addCriterion("registered_address >=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThan(String value) {
            addCriterion("registered_address <", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThanOrEqualTo(String value) {
            addCriterion("registered_address <=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLike(String value) {
            addCriterion("registered_address like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotLike(String value) {
            addCriterion("registered_address not like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIn(List<String> values) {
            addCriterion("registered_address in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotIn(List<String> values) {
            addCriterion("registered_address not in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressBetween(String value1, String value2) {
            addCriterion("registered_address between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotBetween(String value1, String value2) {
            addCriterion("registered_address not between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNull() {
            addCriterion("office_address is null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIsNotNull() {
            addCriterion("office_address is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressEqualTo(String value) {
            addCriterion("office_address =", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotEqualTo(String value) {
            addCriterion("office_address <>", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThan(String value) {
            addCriterion("office_address >", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("office_address >=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThan(String value) {
            addCriterion("office_address <", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLessThanOrEqualTo(String value) {
            addCriterion("office_address <=", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressLike(String value) {
            addCriterion("office_address like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotLike(String value) {
            addCriterion("office_address not like", value, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressIn(List<String> values) {
            addCriterion("office_address in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotIn(List<String> values) {
            addCriterion("office_address not in", values, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressBetween(String value1, String value2) {
            addCriterion("office_address between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andOfficeAddressNotBetween(String value1, String value2) {
            addCriterion("office_address not between", value1, value2, "officeAddress");
            return (Criteria) this;
        }

        public Criteria andRealityControlerIsNull() {
            addCriterion("reality_controler is null");
            return (Criteria) this;
        }

        public Criteria andRealityControlerIsNotNull() {
            addCriterion("reality_controler is not null");
            return (Criteria) this;
        }

        public Criteria andRealityControlerEqualTo(String value) {
            addCriterion("reality_controler =", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerNotEqualTo(String value) {
            addCriterion("reality_controler <>", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerGreaterThan(String value) {
            addCriterion("reality_controler >", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerGreaterThanOrEqualTo(String value) {
            addCriterion("reality_controler >=", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerLessThan(String value) {
            addCriterion("reality_controler <", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerLessThanOrEqualTo(String value) {
            addCriterion("reality_controler <=", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerLike(String value) {
            addCriterion("reality_controler like", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerNotLike(String value) {
            addCriterion("reality_controler not like", value, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerIn(List<String> values) {
            addCriterion("reality_controler in", values, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerNotIn(List<String> values) {
            addCriterion("reality_controler not in", values, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerBetween(String value1, String value2) {
            addCriterion("reality_controler between", value1, value2, "realityControler");
            return (Criteria) this;
        }

        public Criteria andRealityControlerNotBetween(String value1, String value2) {
            addCriterion("reality_controler not between", value1, value2, "realityControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerIsNull() {
            addCriterion("final_controler is null");
            return (Criteria) this;
        }

        public Criteria andFinalControlerIsNotNull() {
            addCriterion("final_controler is not null");
            return (Criteria) this;
        }

        public Criteria andFinalControlerEqualTo(String value) {
            addCriterion("final_controler =", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerNotEqualTo(String value) {
            addCriterion("final_controler <>", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerGreaterThan(String value) {
            addCriterion("final_controler >", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerGreaterThanOrEqualTo(String value) {
            addCriterion("final_controler >=", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerLessThan(String value) {
            addCriterion("final_controler <", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerLessThanOrEqualTo(String value) {
            addCriterion("final_controler <=", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerLike(String value) {
            addCriterion("final_controler like", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerNotLike(String value) {
            addCriterion("final_controler not like", value, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerIn(List<String> values) {
            addCriterion("final_controler in", values, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerNotIn(List<String> values) {
            addCriterion("final_controler not in", values, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerBetween(String value1, String value2) {
            addCriterion("final_controler between", value1, value2, "finalControler");
            return (Criteria) this;
        }

        public Criteria andFinalControlerNotBetween(String value1, String value2) {
            addCriterion("final_controler not between", value1, value2, "finalControler");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateIsNull() {
            addCriterion("establishment_date is null");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateIsNotNull() {
            addCriterion("establishment_date is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateEqualTo(String value) {
            addCriterion("establishment_date =", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateNotEqualTo(String value) {
            addCriterion("establishment_date <>", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateGreaterThan(String value) {
            addCriterion("establishment_date >", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateGreaterThanOrEqualTo(String value) {
            addCriterion("establishment_date >=", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateLessThan(String value) {
            addCriterion("establishment_date <", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateLessThanOrEqualTo(String value) {
            addCriterion("establishment_date <=", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateLike(String value) {
            addCriterion("establishment_date like", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateNotLike(String value) {
            addCriterion("establishment_date not like", value, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateIn(List<String> values) {
            addCriterion("establishment_date in", values, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateNotIn(List<String> values) {
            addCriterion("establishment_date not in", values, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateBetween(String value1, String value2) {
            addCriterion("establishment_date between", value1, value2, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andEstablishmentDateNotBetween(String value1, String value2) {
            addCriterion("establishment_date not between", value1, value2, "establishmentDate");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}