package com.beta.widgets.easycode.service;

import com.beta.widgets.easycode.entity.M8FirstTable2;
import java.util.List;

/**
 * (M8FirstTable2)表服务接口
 *
 * @author makejava
 * @since 2020-06-26 17:33:50
 */
public interface M8FirstTable2Service {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    M8FirstTable2 queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<M8FirstTable2> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param m8FirstTable2 实例对象
     * @return 实例对象
     */
    M8FirstTable2 insert(M8FirstTable2 m8FirstTable2);

    /**
     * 修改数据
     *
     * @param m8FirstTable2 实例对象
     * @return 实例对象
     */
    M8FirstTable2 update(M8FirstTable2 m8FirstTable2);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}