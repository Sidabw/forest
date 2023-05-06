package com.beta.widgets.easycode.service;

import com.beta.widgets.easycode.entity.M8FirstTable;
import java.util.List;

/**
 * (M8FirstTable)表服务接口
 *
 * @author makejava
 * @since 2020-06-26 17:02:22
 */
public interface M8FirstTableService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    M8FirstTable queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<M8FirstTable> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param m8FirstTable 实例对象
     * @return 实例对象
     */
    M8FirstTable insert(M8FirstTable m8FirstTable);

    /**
     * 修改数据
     *
     * @param m8FirstTable 实例对象
     * @return 实例对象
     */
    M8FirstTable update(M8FirstTable m8FirstTable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}