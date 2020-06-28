package com.beta.widgets.easycode.service.impl;

import com.beta.widgets.easycode.entity.M8FirstTable2;
import com.beta.widgets.easycode.dao.M8FirstTable2Dao;
import com.beta.widgets.easycode.service.M8FirstTable2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (M8FirstTable2)表服务实现类
 *
 * @author makejava
 * @since 2020-06-26 17:33:50
 */
@Service("m8FirstTable2Service")
public class M8FirstTable2ServiceImpl implements M8FirstTable2Service {
    @Resource
    private M8FirstTable2Dao m8FirstTable2Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public M8FirstTable2 queryById(Integer id) {
        return this.m8FirstTable2Dao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<M8FirstTable2> queryAllByLimit(int offset, int limit) {
        return this.m8FirstTable2Dao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param m8FirstTable2 实例对象
     * @return 实例对象
     */
    @Override
    public M8FirstTable2 insert(M8FirstTable2 m8FirstTable2) {
        this.m8FirstTable2Dao.insert(m8FirstTable2);
        return m8FirstTable2;
    }

    /**
     * 修改数据
     *
     * @param m8FirstTable2 实例对象
     * @return 实例对象
     */
    @Override
    public M8FirstTable2 update(M8FirstTable2 m8FirstTable2) {
        this.m8FirstTable2Dao.update(m8FirstTable2);
        return this.queryById(m8FirstTable2.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.m8FirstTable2Dao.deleteById(id) > 0;
    }
}