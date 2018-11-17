/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: EsController
 * Author:   feiyi
 * Date:     2018/11/17 下午3:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/11/17
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/es")
public class EsController {

    private final IEsService esServiceImpl;

    @Autowired
    public EsController(IEsService esServiceImpl){
        this.esServiceImpl = esServiceImpl;
    }

    @RequestMapping("/test")
    public Object esTest(){
        System.out.println("service in");
        return esServiceImpl.esTest();
    }
}
