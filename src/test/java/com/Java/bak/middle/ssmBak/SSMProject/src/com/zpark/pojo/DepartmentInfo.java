package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.pojo;

public class DepartmentInfo {
    private Integer departmentId;

    private String departmentName;

    private String departmentDesc;

    private String isUsed;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc == null ? null : departmentDesc.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

	@Override
	public String toString() {
		return "DepartmentInfo [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentDesc=" + departmentDesc + ", isUsed=" + isUsed + "]";
	}
    
}