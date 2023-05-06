package com.beta.widgets.gp.dao;

import com.beta.widgets.gp.dao.BlobTestEntity;
import com.beta.widgets.gp.dao.BlobTestEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlobTestEntityMapper {
    long countByExample(BlobTestEntityExample example);

    int deleteByExample(BlobTestEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlobTestEntity record);

    int insertSelective(BlobTestEntity record);

    List<BlobTestEntity> selectByExampleWithBLOBs(BlobTestEntityExample example);

    List<BlobTestEntity> selectByExample(BlobTestEntityExample example);

    BlobTestEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlobTestEntity record, @Param("example") BlobTestEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") BlobTestEntity record, @Param("example") BlobTestEntityExample example);

    int updateByExample(@Param("record") BlobTestEntity record, @Param("example") BlobTestEntityExample example);

    int updateByPrimaryKeySelective(BlobTestEntity record);

    int updateByPrimaryKeyWithBLOBs(BlobTestEntity record);

    int updateByPrimaryKey(BlobTestEntity record);
}