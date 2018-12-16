package com.beta.security.dao;

import java.util.ArrayList;
import java.util.List;

public class SecuritiesProductInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecuritiesProductInfoExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedIsNull() {
            addCriterion("gmt8_created is null");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedIsNotNull() {
            addCriterion("gmt8_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedEqualTo(String value) {
            addCriterion("gmt8_created =", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedNotEqualTo(String value) {
            addCriterion("gmt8_created <>", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedGreaterThan(String value) {
            addCriterion("gmt8_created >", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedGreaterThanOrEqualTo(String value) {
            addCriterion("gmt8_created >=", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedLessThan(String value) {
            addCriterion("gmt8_created <", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedLessThanOrEqualTo(String value) {
            addCriterion("gmt8_created <=", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedLike(String value) {
            addCriterion("gmt8_created like", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedNotLike(String value) {
            addCriterion("gmt8_created not like", value, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedIn(List<String> values) {
            addCriterion("gmt8_created in", values, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedNotIn(List<String> values) {
            addCriterion("gmt8_created not in", values, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedBetween(String value1, String value2) {
            addCriterion("gmt8_created between", value1, value2, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8CreatedNotBetween(String value1, String value2) {
            addCriterion("gmt8_created not between", value1, value2, "gmt8Created");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedIsNull() {
            addCriterion("gmt8_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedIsNotNull() {
            addCriterion("gmt8_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedEqualTo(String value) {
            addCriterion("gmt8_modified =", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedNotEqualTo(String value) {
            addCriterion("gmt8_modified <>", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedGreaterThan(String value) {
            addCriterion("gmt8_modified >", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedGreaterThanOrEqualTo(String value) {
            addCriterion("gmt8_modified >=", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedLessThan(String value) {
            addCriterion("gmt8_modified <", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedLessThanOrEqualTo(String value) {
            addCriterion("gmt8_modified <=", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedLike(String value) {
            addCriterion("gmt8_modified like", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedNotLike(String value) {
            addCriterion("gmt8_modified not like", value, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedIn(List<String> values) {
            addCriterion("gmt8_modified in", values, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedNotIn(List<String> values) {
            addCriterion("gmt8_modified not in", values, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedBetween(String value1, String value2) {
            addCriterion("gmt8_modified between", value1, value2, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andGmt8ModifiedNotBetween(String value1, String value2) {
            addCriterion("gmt8_modified not between", value1, value2, "gmt8Modified");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andHisNamesIsNull() {
            addCriterion("his_names is null");
            return (Criteria) this;
        }

        public Criteria andHisNamesIsNotNull() {
            addCriterion("his_names is not null");
            return (Criteria) this;
        }

        public Criteria andHisNamesEqualTo(String value) {
            addCriterion("his_names =", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesNotEqualTo(String value) {
            addCriterion("his_names <>", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesGreaterThan(String value) {
            addCriterion("his_names >", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesGreaterThanOrEqualTo(String value) {
            addCriterion("his_names >=", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesLessThan(String value) {
            addCriterion("his_names <", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesLessThanOrEqualTo(String value) {
            addCriterion("his_names <=", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesLike(String value) {
            addCriterion("his_names like", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesNotLike(String value) {
            addCriterion("his_names not like", value, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesIn(List<String> values) {
            addCriterion("his_names in", values, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesNotIn(List<String> values) {
            addCriterion("his_names not in", values, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesBetween(String value1, String value2) {
            addCriterion("his_names between", value1, value2, "hisNames");
            return (Criteria) this;
        }

        public Criteria andHisNamesNotBetween(String value1, String value2) {
            addCriterion("his_names not between", value1, value2, "hisNames");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Long value) {
            addCriterion("cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Long value) {
            addCriterion("cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Long value) {
            addCriterion("cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Long value) {
            addCriterion("cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Long value) {
            addCriterion("cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Long> values) {
            addCriterion("cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Long> values) {
            addCriterion("cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Long value1, Long value2) {
            addCriterion("cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Long value1, Long value2) {
            addCriterion("cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNull() {
            addCriterion("cate_name is null");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNotNull() {
            addCriterion("cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCateNameEqualTo(String value) {
            addCriterion("cate_name =", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotEqualTo(String value) {
            addCriterion("cate_name <>", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThan(String value) {
            addCriterion("cate_name >", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("cate_name >=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThan(String value) {
            addCriterion("cate_name <", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThanOrEqualTo(String value) {
            addCriterion("cate_name <=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLike(String value) {
            addCriterion("cate_name like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotLike(String value) {
            addCriterion("cate_name not like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameIn(List<String> values) {
            addCriterion("cate_name in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotIn(List<String> values) {
            addCriterion("cate_name not in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameBetween(String value1, String value2) {
            addCriterion("cate_name between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotBetween(String value1, String value2) {
            addCriterion("cate_name not between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andAttrTagsIsNull() {
            addCriterion("attr_tags is null");
            return (Criteria) this;
        }

        public Criteria andAttrTagsIsNotNull() {
            addCriterion("attr_tags is not null");
            return (Criteria) this;
        }

        public Criteria andAttrTagsEqualTo(String value) {
            addCriterion("attr_tags =", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsNotEqualTo(String value) {
            addCriterion("attr_tags <>", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsGreaterThan(String value) {
            addCriterion("attr_tags >", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsGreaterThanOrEqualTo(String value) {
            addCriterion("attr_tags >=", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsLessThan(String value) {
            addCriterion("attr_tags <", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsLessThanOrEqualTo(String value) {
            addCriterion("attr_tags <=", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsLike(String value) {
            addCriterion("attr_tags like", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsNotLike(String value) {
            addCriterion("attr_tags not like", value, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsIn(List<String> values) {
            addCriterion("attr_tags in", values, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsNotIn(List<String> values) {
            addCriterion("attr_tags not in", values, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsBetween(String value1, String value2) {
            addCriterion("attr_tags between", value1, value2, "attrTags");
            return (Criteria) this;
        }

        public Criteria andAttrTagsNotBetween(String value1, String value2) {
            addCriterion("attr_tags not between", value1, value2, "attrTags");
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