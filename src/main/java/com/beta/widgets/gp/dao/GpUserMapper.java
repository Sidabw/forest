package com.beta.widgets.gp.dao;

import com.beta.widgets.gp.dao.GpUser;
import com.beta.widgets.gp.dao.GpUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GpUserMapper {
    long countByExample(GpUserExample example);

    int deleteByExample(GpUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GpUser record);

    int insertSelective(GpUser record);

    List<GpUser> selectByExample(GpUserExample example);

    GpUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GpUser record, @Param("example") GpUserExample example);

    int updateByExample(@Param("record") GpUser record, @Param("example") GpUserExample example);

    int updateByPrimaryKeySelective(GpUser record);

    int updateByPrimaryKey(GpUser record);
}