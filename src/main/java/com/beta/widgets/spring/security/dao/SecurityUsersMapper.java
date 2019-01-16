package com.beta.widgets.spring.security.dao;


import com.beta.widgets.spring.security.dao.SecurityUsers;
import com.beta.widgets.spring.security.dao.SecurityUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityUsersMapper {
    long countByExample(SecurityUsersExample example);

    int deleteByExample(SecurityUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityUsers record);

    int insertSelective(SecurityUsers record);

    List<SecurityUsers> selectByExample(SecurityUsersExample example);

    SecurityUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityUsers record, @Param("example") SecurityUsersExample example);

    int updateByExample(@Param("record") SecurityUsers record, @Param("example") SecurityUsersExample example);

    int updateByPrimaryKeySelective(SecurityUsers record);

    int updateByPrimaryKey(SecurityUsers record);
}
