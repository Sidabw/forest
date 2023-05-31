package com.ego.mapper;

import com.ego.pojo.TbUser;
import com.ego.pojo.TbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {
	//根据用户名和密码登陆验证
	TbUser selectByUnameAndPwd(TbUser user);
	
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}