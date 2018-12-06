/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: EsClient
 * Author:   feiyi
 * Date:     2018/11/17 下午3:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.widgets.elasticsearch;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2018/11/17
 * @since 1.0.0
 */
@Component
public class EsClient {
    @Autowired
    private TransportClient transportClient;

    private static TransportClient client;

    /**
     * @PostContruct是spring框架的注解 spring容器初始化的时候执行该方法
     */
    @PostConstruct
    public void init() {
        client = this.transportClient;
    }

    public Object findById(){
        GetRequest getRequest = new GetRequest("bank");
        getRequest.id("25");
        ActionFuture<GetResponse> getResponseActionFuture = client.get(getRequest);
        GetResponse getFields = getResponseActionFuture.actionGet();
        Map<String, Object> source = getFields.getSource();
        System.out.println(getResponseActionFuture.actionGet());
        System.out.println(source.get("firstname"));
        return source.get("firstname");
    }

}
