package com.beta.widgets.easycode.controller;

import com.beta.widgets.easycode.entity.M8FirstTable2;
import com.beta.widgets.easycode.service.M8FirstTable2Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (M8FirstTable2)表控制层
 *
 * @author makejava
 * @since 2020-06-26 17:33:50
 */
@RestController
@RequestMapping("m8FirstTable2")
public class M8FirstTable2Controller {
    /**
     * 服务对象
     */
    @Resource
    private M8FirstTable2Service m8FirstTable2Service;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public M8FirstTable2 selectOne(Integer id) {
        return this.m8FirstTable2Service.queryById(id);
    }

}