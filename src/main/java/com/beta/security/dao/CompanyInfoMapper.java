package com.beta.security.dao;

import com.beta.security.dao.CompanyInfo;
import com.beta.security.dao.CompanyInfoExample;
import com.beta.security.dao.CompanyInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyInfoMapper {
    long countByExample(CompanyInfoExample example);

    int deleteByExample(CompanyInfoExample example);

    int deleteByPrimaryKey(CompanyInfoKey key);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    CompanyInfo selectByPrimaryKey(CompanyInfoKey key);

    int updateByExampleSelective(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    int updateByExample(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}