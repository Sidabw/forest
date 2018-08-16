package com.beta.scheduler.dao;

import com.beta.scheduler.dao.SchedulerJob;
import com.beta.scheduler.dao.SchedulerJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchedulerJobMapper {
    long countByExample(SchedulerJobExample example);

    int deleteByExample(SchedulerJobExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SchedulerJob record);

    int insertSelective(SchedulerJob record);

    List<SchedulerJob> selectByExample(SchedulerJobExample example);

    SchedulerJob selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SchedulerJob record, @Param("example") SchedulerJobExample example);

    int updateByExample(@Param("record") SchedulerJob record, @Param("example") SchedulerJobExample example);

    int updateByPrimaryKeySelective(SchedulerJob record);

    int updateByPrimaryKey(SchedulerJob record);
}