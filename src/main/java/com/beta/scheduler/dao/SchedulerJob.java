package com.beta.scheduler.dao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SchedulerJob implements Serializable {
    private String userId;

    private String userName;

    private String userJob;

    private static final long serialVersionUID = 1L;


}