/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: IProducerService
 * Author:   feiyi
 * Date:     2018/12/4 下午8:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.kafka.service;

/**
 * 〈一句话功能简述〉: 
 * 〈〉
 *
 * @author feiyi
 * @create 2018/12/4
 * @since 1.0.0
 */
public interface IProducerService {
    public void send(String topic , String payload);
}
