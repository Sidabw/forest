package com.ego.pojo;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private Integer departmentId;

    private Integer roleId;

    private String pic;

    private String userName;

    private String userSex;

    private String userMobile;

    private Integer userAge;

    private String userAddress;

    private String userNum;

    private String userPw;

    private String userTel;

    private String userIdnum;

    private String userEmail;

    private Date userAddtime;

    private String userAddman;

    private Date userChangetime;

    private String userChangeman;

    private String userIntest;

    private String userDiploma;

    private String userBankcard;

    private String userNation;

    private String isMarried;

    private String isUsed;

    @Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", departmentId=" + departmentId + ", roleId=" + roleId + ", pic=" + pic
				+ ", userName=" + userName + ", userSex=" + userSex + ", userMobile=" + userMobile + ", userAge="
				+ userAge + ", userAddress=" + userAddress + ", userNum=" + userNum + ", userPw=" + userPw
				+ ", userTel=" + userTel + ", userIdnum=" + userIdnum + ", userEmail=" + userEmail + ", userAddtime="
				+ userAddtime + ", userAddman=" + userAddman + ", userChangetime=" + userChangetime + ", userChangeman="
				+ userChangeman + ", userIntest=" + userIntest + ", userDiploma=" + userDiploma + ", userBankcard="
				+ userBankcard + ", userNation=" + userNation + ", isMarried=" + isMarried + ", isUsed=" + isUsed + "]";
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw == null ? null : userPw.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserIdnum() {
        return userIdnum;
    }

    public void setUserIdnum(String userIdnum) {
        this.userIdnum = userIdnum == null ? null : userIdnum.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getUserAddtime() {
        return userAddtime;
    }

    public void setUserAddtime(Date userAddtime) {
        this.userAddtime = userAddtime;
    }

    public String getUserAddman() {
        return userAddman;
    }

    public void setUserAddman(String userAddman) {
        this.userAddman = userAddman == null ? null : userAddman.trim();
    }

    public Date getUserChangetime() {
        return userChangetime;
    }

    public void setUserChangetime(Date userChangetime) {
        this.userChangetime = userChangetime;
    }

    public String getUserChangeman() {
        return userChangeman;
    }

    public void setUserChangeman(String userChangeman) {
        this.userChangeman = userChangeman == null ? null : userChangeman.trim();
    }

    public String getUserIntest() {
        return userIntest;
    }

    public void setUserIntest(String userIntest) {
        this.userIntest = userIntest == null ? null : userIntest.trim();
    }

    public String getUserDiploma() {
        return userDiploma;
    }

    public void setUserDiploma(String userDiploma) {
        this.userDiploma = userDiploma == null ? null : userDiploma.trim();
    }

    public String getUserBankcard() {
        return userBankcard;
    }

    public void setUserBankcard(String userBankcard) {
        this.userBankcard = userBankcard == null ? null : userBankcard.trim();
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation == null ? null : userNation.trim();
    }

    public String getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(String isMarried) {
        this.isMarried = isMarried == null ? null : isMarried.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }
}