package com.ego.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("user_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("user_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("user_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("user_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("user_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("user_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("user_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("user_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("user_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("user_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("user_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("user_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("user_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("user_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNull() {
            addCriterion("user_age is null");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNotNull() {
            addCriterion("user_age is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgeEqualTo(Integer value) {
            addCriterion("user_age =", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotEqualTo(Integer value) {
            addCriterion("user_age <>", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThan(Integer value) {
            addCriterion("user_age >", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_age >=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThan(Integer value) {
            addCriterion("user_age <", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThanOrEqualTo(Integer value) {
            addCriterion("user_age <=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeIn(List<Integer> values) {
            addCriterion("user_age in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotIn(List<Integer> values) {
            addCriterion("user_age not in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeBetween(Integer value1, Integer value2) {
            addCriterion("user_age between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_age not between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("user_address is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("user_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("user_address =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("user_address <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("user_address >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_address >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("user_address <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("user_address <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("user_address like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("user_address not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("user_address in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("user_address not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("user_address between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("user_address not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserNumIsNull() {
            addCriterion("user_num is null");
            return (Criteria) this;
        }

        public Criteria andUserNumIsNotNull() {
            addCriterion("user_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserNumEqualTo(String value) {
            addCriterion("user_num =", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotEqualTo(String value) {
            addCriterion("user_num <>", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumGreaterThan(String value) {
            addCriterion("user_num >", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumGreaterThanOrEqualTo(String value) {
            addCriterion("user_num >=", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLessThan(String value) {
            addCriterion("user_num <", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLessThanOrEqualTo(String value) {
            addCriterion("user_num <=", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumLike(String value) {
            addCriterion("user_num like", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotLike(String value) {
            addCriterion("user_num not like", value, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumIn(List<String> values) {
            addCriterion("user_num in", values, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotIn(List<String> values) {
            addCriterion("user_num not in", values, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumBetween(String value1, String value2) {
            addCriterion("user_num between", value1, value2, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserNumNotBetween(String value1, String value2) {
            addCriterion("user_num not between", value1, value2, "userNum");
            return (Criteria) this;
        }

        public Criteria andUserPwIsNull() {
            addCriterion("user_pw is null");
            return (Criteria) this;
        }

        public Criteria andUserPwIsNotNull() {
            addCriterion("user_pw is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwEqualTo(String value) {
            addCriterion("user_pw =", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotEqualTo(String value) {
            addCriterion("user_pw <>", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwGreaterThan(String value) {
            addCriterion("user_pw >", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwGreaterThanOrEqualTo(String value) {
            addCriterion("user_pw >=", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwLessThan(String value) {
            addCriterion("user_pw <", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwLessThanOrEqualTo(String value) {
            addCriterion("user_pw <=", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwLike(String value) {
            addCriterion("user_pw like", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotLike(String value) {
            addCriterion("user_pw not like", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwIn(List<String> values) {
            addCriterion("user_pw in", values, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotIn(List<String> values) {
            addCriterion("user_pw not in", values, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwBetween(String value1, String value2) {
            addCriterion("user_pw between", value1, value2, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotBetween(String value1, String value2) {
            addCriterion("user_pw not between", value1, value2, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("user_tel is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("user_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("user_tel =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("user_tel <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("user_tel >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("user_tel >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("user_tel <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("user_tel <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("user_tel like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("user_tel not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("user_tel in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("user_tel not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("user_tel between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("user_tel not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserIdnumIsNull() {
            addCriterion("user_idnum is null");
            return (Criteria) this;
        }

        public Criteria andUserIdnumIsNotNull() {
            addCriterion("user_idnum is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdnumEqualTo(String value) {
            addCriterion("user_idnum =", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumNotEqualTo(String value) {
            addCriterion("user_idnum <>", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumGreaterThan(String value) {
            addCriterion("user_idnum >", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("user_idnum >=", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumLessThan(String value) {
            addCriterion("user_idnum <", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumLessThanOrEqualTo(String value) {
            addCriterion("user_idnum <=", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumLike(String value) {
            addCriterion("user_idnum like", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumNotLike(String value) {
            addCriterion("user_idnum not like", value, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumIn(List<String> values) {
            addCriterion("user_idnum in", values, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumNotIn(List<String> values) {
            addCriterion("user_idnum not in", values, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumBetween(String value1, String value2) {
            addCriterion("user_idnum between", value1, value2, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserIdnumNotBetween(String value1, String value2) {
            addCriterion("user_idnum not between", value1, value2, "userIdnum");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeIsNull() {
            addCriterion("user_addtime is null");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeIsNotNull() {
            addCriterion("user_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeEqualTo(Date value) {
            addCriterion("user_addtime =", value, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeNotEqualTo(Date value) {
            addCriterion("user_addtime <>", value, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeGreaterThan(Date value) {
            addCriterion("user_addtime >", value, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_addtime >=", value, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeLessThan(Date value) {
            addCriterion("user_addtime <", value, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("user_addtime <=", value, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeIn(List<Date> values) {
            addCriterion("user_addtime in", values, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeNotIn(List<Date> values) {
            addCriterion("user_addtime not in", values, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeBetween(Date value1, Date value2) {
            addCriterion("user_addtime between", value1, value2, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("user_addtime not between", value1, value2, "userAddtime");
            return (Criteria) this;
        }

        public Criteria andUserAddmanIsNull() {
            addCriterion("user_addman is null");
            return (Criteria) this;
        }

        public Criteria andUserAddmanIsNotNull() {
            addCriterion("user_addman is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddmanEqualTo(String value) {
            addCriterion("user_addman =", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanNotEqualTo(String value) {
            addCriterion("user_addman <>", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanGreaterThan(String value) {
            addCriterion("user_addman >", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanGreaterThanOrEqualTo(String value) {
            addCriterion("user_addman >=", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanLessThan(String value) {
            addCriterion("user_addman <", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanLessThanOrEqualTo(String value) {
            addCriterion("user_addman <=", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanLike(String value) {
            addCriterion("user_addman like", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanNotLike(String value) {
            addCriterion("user_addman not like", value, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanIn(List<String> values) {
            addCriterion("user_addman in", values, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanNotIn(List<String> values) {
            addCriterion("user_addman not in", values, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanBetween(String value1, String value2) {
            addCriterion("user_addman between", value1, value2, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserAddmanNotBetween(String value1, String value2) {
            addCriterion("user_addman not between", value1, value2, "userAddman");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeIsNull() {
            addCriterion("user_changetime is null");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeIsNotNull() {
            addCriterion("user_changetime is not null");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeEqualTo(Date value) {
            addCriterion("user_changetime =", value, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeNotEqualTo(Date value) {
            addCriterion("user_changetime <>", value, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeGreaterThan(Date value) {
            addCriterion("user_changetime >", value, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_changetime >=", value, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeLessThan(Date value) {
            addCriterion("user_changetime <", value, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeLessThanOrEqualTo(Date value) {
            addCriterion("user_changetime <=", value, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeIn(List<Date> values) {
            addCriterion("user_changetime in", values, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeNotIn(List<Date> values) {
            addCriterion("user_changetime not in", values, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeBetween(Date value1, Date value2) {
            addCriterion("user_changetime between", value1, value2, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangetimeNotBetween(Date value1, Date value2) {
            addCriterion("user_changetime not between", value1, value2, "userChangetime");
            return (Criteria) this;
        }

        public Criteria andUserChangemanIsNull() {
            addCriterion("user_changeman is null");
            return (Criteria) this;
        }

        public Criteria andUserChangemanIsNotNull() {
            addCriterion("user_changeman is not null");
            return (Criteria) this;
        }

        public Criteria andUserChangemanEqualTo(String value) {
            addCriterion("user_changeman =", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanNotEqualTo(String value) {
            addCriterion("user_changeman <>", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanGreaterThan(String value) {
            addCriterion("user_changeman >", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanGreaterThanOrEqualTo(String value) {
            addCriterion("user_changeman >=", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanLessThan(String value) {
            addCriterion("user_changeman <", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanLessThanOrEqualTo(String value) {
            addCriterion("user_changeman <=", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanLike(String value) {
            addCriterion("user_changeman like", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanNotLike(String value) {
            addCriterion("user_changeman not like", value, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanIn(List<String> values) {
            addCriterion("user_changeman in", values, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanNotIn(List<String> values) {
            addCriterion("user_changeman not in", values, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanBetween(String value1, String value2) {
            addCriterion("user_changeman between", value1, value2, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserChangemanNotBetween(String value1, String value2) {
            addCriterion("user_changeman not between", value1, value2, "userChangeman");
            return (Criteria) this;
        }

        public Criteria andUserIntestIsNull() {
            addCriterion("user_intest is null");
            return (Criteria) this;
        }

        public Criteria andUserIntestIsNotNull() {
            addCriterion("user_intest is not null");
            return (Criteria) this;
        }

        public Criteria andUserIntestEqualTo(String value) {
            addCriterion("user_intest =", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestNotEqualTo(String value) {
            addCriterion("user_intest <>", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestGreaterThan(String value) {
            addCriterion("user_intest >", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestGreaterThanOrEqualTo(String value) {
            addCriterion("user_intest >=", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestLessThan(String value) {
            addCriterion("user_intest <", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestLessThanOrEqualTo(String value) {
            addCriterion("user_intest <=", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestLike(String value) {
            addCriterion("user_intest like", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestNotLike(String value) {
            addCriterion("user_intest not like", value, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestIn(List<String> values) {
            addCriterion("user_intest in", values, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestNotIn(List<String> values) {
            addCriterion("user_intest not in", values, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestBetween(String value1, String value2) {
            addCriterion("user_intest between", value1, value2, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserIntestNotBetween(String value1, String value2) {
            addCriterion("user_intest not between", value1, value2, "userIntest");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaIsNull() {
            addCriterion("user_diploma is null");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaIsNotNull() {
            addCriterion("user_diploma is not null");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaEqualTo(String value) {
            addCriterion("user_diploma =", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaNotEqualTo(String value) {
            addCriterion("user_diploma <>", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaGreaterThan(String value) {
            addCriterion("user_diploma >", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("user_diploma >=", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaLessThan(String value) {
            addCriterion("user_diploma <", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaLessThanOrEqualTo(String value) {
            addCriterion("user_diploma <=", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaLike(String value) {
            addCriterion("user_diploma like", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaNotLike(String value) {
            addCriterion("user_diploma not like", value, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaIn(List<String> values) {
            addCriterion("user_diploma in", values, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaNotIn(List<String> values) {
            addCriterion("user_diploma not in", values, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaBetween(String value1, String value2) {
            addCriterion("user_diploma between", value1, value2, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserDiplomaNotBetween(String value1, String value2) {
            addCriterion("user_diploma not between", value1, value2, "userDiploma");
            return (Criteria) this;
        }

        public Criteria andUserBankcardIsNull() {
            addCriterion("user_bankcard is null");
            return (Criteria) this;
        }

        public Criteria andUserBankcardIsNotNull() {
            addCriterion("user_bankcard is not null");
            return (Criteria) this;
        }

        public Criteria andUserBankcardEqualTo(String value) {
            addCriterion("user_bankcard =", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardNotEqualTo(String value) {
            addCriterion("user_bankcard <>", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardGreaterThan(String value) {
            addCriterion("user_bankcard >", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardGreaterThanOrEqualTo(String value) {
            addCriterion("user_bankcard >=", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardLessThan(String value) {
            addCriterion("user_bankcard <", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardLessThanOrEqualTo(String value) {
            addCriterion("user_bankcard <=", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardLike(String value) {
            addCriterion("user_bankcard like", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardNotLike(String value) {
            addCriterion("user_bankcard not like", value, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardIn(List<String> values) {
            addCriterion("user_bankcard in", values, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardNotIn(List<String> values) {
            addCriterion("user_bankcard not in", values, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardBetween(String value1, String value2) {
            addCriterion("user_bankcard between", value1, value2, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserBankcardNotBetween(String value1, String value2) {
            addCriterion("user_bankcard not between", value1, value2, "userBankcard");
            return (Criteria) this;
        }

        public Criteria andUserNationIsNull() {
            addCriterion("user_nation is null");
            return (Criteria) this;
        }

        public Criteria andUserNationIsNotNull() {
            addCriterion("user_nation is not null");
            return (Criteria) this;
        }

        public Criteria andUserNationEqualTo(String value) {
            addCriterion("user_nation =", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationNotEqualTo(String value) {
            addCriterion("user_nation <>", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationGreaterThan(String value) {
            addCriterion("user_nation >", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationGreaterThanOrEqualTo(String value) {
            addCriterion("user_nation >=", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationLessThan(String value) {
            addCriterion("user_nation <", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationLessThanOrEqualTo(String value) {
            addCriterion("user_nation <=", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationLike(String value) {
            addCriterion("user_nation like", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationNotLike(String value) {
            addCriterion("user_nation not like", value, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationIn(List<String> values) {
            addCriterion("user_nation in", values, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationNotIn(List<String> values) {
            addCriterion("user_nation not in", values, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationBetween(String value1, String value2) {
            addCriterion("user_nation between", value1, value2, "userNation");
            return (Criteria) this;
        }

        public Criteria andUserNationNotBetween(String value1, String value2) {
            addCriterion("user_nation not between", value1, value2, "userNation");
            return (Criteria) this;
        }

        public Criteria andIsMarriedIsNull() {
            addCriterion("is_married is null");
            return (Criteria) this;
        }

        public Criteria andIsMarriedIsNotNull() {
            addCriterion("is_married is not null");
            return (Criteria) this;
        }

        public Criteria andIsMarriedEqualTo(String value) {
            addCriterion("is_married =", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedNotEqualTo(String value) {
            addCriterion("is_married <>", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedGreaterThan(String value) {
            addCriterion("is_married >", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedGreaterThanOrEqualTo(String value) {
            addCriterion("is_married >=", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedLessThan(String value) {
            addCriterion("is_married <", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedLessThanOrEqualTo(String value) {
            addCriterion("is_married <=", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedLike(String value) {
            addCriterion("is_married like", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedNotLike(String value) {
            addCriterion("is_married not like", value, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedIn(List<String> values) {
            addCriterion("is_married in", values, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedNotIn(List<String> values) {
            addCriterion("is_married not in", values, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedBetween(String value1, String value2) {
            addCriterion("is_married between", value1, value2, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsMarriedNotBetween(String value1, String value2) {
            addCriterion("is_married not between", value1, value2, "isMarried");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNull() {
            addCriterion("is_used is null");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNotNull() {
            addCriterion("is_used is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsedEqualTo(String value) {
            addCriterion("is_used =", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotEqualTo(String value) {
            addCriterion("is_used <>", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThan(String value) {
            addCriterion("is_used >", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThanOrEqualTo(String value) {
            addCriterion("is_used >=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThan(String value) {
            addCriterion("is_used <", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThanOrEqualTo(String value) {
            addCriterion("is_used <=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLike(String value) {
            addCriterion("is_used like", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotLike(String value) {
            addCriterion("is_used not like", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedIn(List<String> values) {
            addCriterion("is_used in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotIn(List<String> values) {
            addCriterion("is_used not in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedBetween(String value1, String value2) {
            addCriterion("is_used between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotBetween(String value1, String value2) {
            addCriterion("is_used not between", value1, value2, "isUsed");
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