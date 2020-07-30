package com.beta.widgets.easycode.service.impl;

import com.beta.widgets.easycode.entity.M8FirstTable;
import com.beta.widgets.easycode.dao.M8FirstTableDao;
import com.beta.widgets.easycode.service.M8FirstTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (M8FirstTable)表服务实现类
 *
 * @author makejava
 * @since 2020-06-26 17:02:24
 */
@Service
public class M8FirstTableServiceImpl implements M8FirstTableService {
    @Resource
    private M8FirstTableDao m8FirstTableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public M8FirstTable queryById(Integer id) {
        return this.m8FirstTableDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<M8FirstTable> queryAllByLimit(int offset, int limit) {
        return this.m8FirstTableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param m8FirstTable 实例对象
     * @return 实例对象
     */
    @Override
    public M8FirstTable insert(M8FirstTable m8FirstTable) {
        this.m8FirstTableDao.insert(m8FirstTable);
        return m8FirstTable;
    }

    /**
     * 修改数据
     *
     * @param m8FirstTable 实例对象
     * @return 实例对象
     */
    @Override
    public M8FirstTable update(M8FirstTable m8FirstTable) {
        this.m8FirstTableDao.update(m8FirstTable);
        return this.queryById(m8FirstTable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.m8FirstTableDao.deleteById(id) > 0;
    }
}