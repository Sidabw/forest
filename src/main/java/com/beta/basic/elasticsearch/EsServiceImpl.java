/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: EsServiceImpl
 * Author:   feiyi
 * Date:     2018/11/17 下午3:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/11/17
 * @since 1.0.0
 */
@Service
public class EsServiceImpl implements IEsService{

    @Autowired
    private EsClient client;

    @Override
    public Object esTest() {
        return client.findById();
    }
}

