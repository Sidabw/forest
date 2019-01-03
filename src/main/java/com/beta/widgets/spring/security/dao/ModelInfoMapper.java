package com.beta.widgets.spring.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelInfoMapper {
    long countByExample(ModelInfoExample example);

    int deleteByExample(ModelInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModelInfo record);

    int insertSelective(ModelInfo record);

    List<ModelInfo> selectByExample(ModelInfoExample example);

    ModelInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModelInfo record, @Param("example") ModelInfoExample example);

    int updateByExample(@Param("record") ModelInfo record, @Param("example") ModelInfoExample example);

    int updateByPrimaryKeySelective(ModelInfo record);

    int updateByPrimaryKey(ModelInfo record);
}