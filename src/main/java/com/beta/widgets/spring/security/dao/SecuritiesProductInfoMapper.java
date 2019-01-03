package com.beta.widgets.spring.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecuritiesProductInfoMapper {
    long countByExample(SecuritiesProductInfoExample example);

    int deleteByExample(SecuritiesProductInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecuritiesProductInfo record);

    int insertSelective(SecuritiesProductInfo record);

    List<SecuritiesProductInfo> selectByExampleWithBLOBs(SecuritiesProductInfoExample example);

    List<SecuritiesProductInfo> selectByExample(SecuritiesProductInfoExample example);

    SecuritiesProductInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecuritiesProductInfo record, @Param("example") SecuritiesProductInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SecuritiesProductInfo record, @Param("example") SecuritiesProductInfoExample example);

    int updateByExample(@Param("record") SecuritiesProductInfo record, @Param("example") SecuritiesProductInfoExample example);

    int updateByPrimaryKeySelective(SecuritiesProductInfo record);

    int updateByPrimaryKeyWithBLOBs(SecuritiesProductInfo record);

    int updateByPrimaryKey(SecuritiesProductInfo record);
}