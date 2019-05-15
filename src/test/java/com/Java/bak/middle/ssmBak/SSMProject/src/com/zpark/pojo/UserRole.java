package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.pojo;

public class UserRole {
    private Integer roleId;

    private String roleName;

    private Integer rolePower;

    private String isUsed;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRolePower() {
        return rolePower;
    }

    public void setRolePower(Integer rolePower) {
        this.rolePower = rolePower;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + ", rolePower=" + rolePower + ", isUsed="
				+ isUsed + "]";
	}
}