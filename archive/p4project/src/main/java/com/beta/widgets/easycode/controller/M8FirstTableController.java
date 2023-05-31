package com.beta.widgets.easycode.controller;

import com.beta.widgets.easycode.entity.M8FirstTable;
import com.beta.widgets.easycode.service.M8FirstTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (M8FirstTable)表控制层
 *
 * @author makejava
 * @since 2020-06-26 17:02:25
 */
@RestController
@RequestMapping("m8FirstTable")
public class M8FirstTableController {
    /**
     * 服务对象
     */
    @Resource
    private M8FirstTableService m8FirstTableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public M8FirstTable selectOne(Integer id) {
        return this.m8FirstTableService.queryById(id);
    }

}