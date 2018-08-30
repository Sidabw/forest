package com.beta.scheduler.dao;

import java.io.Serializable;

public class SchedulerJob implements Serializable {
    private String userId;

    private String userName;

    private String userJob;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob == null ? null : userJob.trim();
    }
}