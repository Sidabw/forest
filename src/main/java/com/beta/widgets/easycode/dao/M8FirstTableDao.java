package com.beta.widgets.easycode.dao;

import com.beta.widgets.easycode.entity.M8FirstTable;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (M8FirstTable)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-26 17:02:19
 */
public interface M8FirstTableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    M8FirstTable queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<M8FirstTable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param m8FirstTable 实例对象
     * @return 对象列表
     */
    List<M8FirstTable> queryAll(M8FirstTable m8FirstTable);

    /**
     * 新增数据
     *
     * @param m8FirstTable 实例对象
     * @return 影响行数
     */
    int insert(M8FirstTable m8FirstTable);

    /**
     * 修改数据
     *
     * @param m8FirstTable 实例对象
     * @return 影响行数
     */
    int update(M8FirstTable m8FirstTable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}