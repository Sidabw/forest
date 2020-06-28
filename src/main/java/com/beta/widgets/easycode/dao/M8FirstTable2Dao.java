package com.beta.widgets.easycode.dao;

import com.beta.widgets.easycode.entity.M8FirstTable2;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (M8FirstTable2)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-26 17:33:50
 */
public interface M8FirstTable2Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    M8FirstTable2 queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<M8FirstTable2> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param m8FirstTable2 实例对象
     * @return 对象列表
     */
    List<M8FirstTable2> queryAll(M8FirstTable2 m8FirstTable2);

    /**
     * 新增数据
     *
     * @param m8FirstTable2 实例对象
     * @return 影响行数
     */
    int insert(M8FirstTable2 m8FirstTable2);

    /**
     * 修改数据
     *
     * @param m8FirstTable2 实例对象
     * @return 影响行数
     */
    int update(M8FirstTable2 m8FirstTable2);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}