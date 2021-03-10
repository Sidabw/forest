/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ClientDemo
 * Author:   feiyi
 * Date:     2019/12/3 4:15 PM
 * Description: 获取client
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.elasticsearch.rest;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;

import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈获取client〉
 *
 * @author feiyi
 * @create 2019/12/3
 * @since 1.0.0
 */
public class ClientDemo {

    public static RestHighLevelClient getClient(String host, int port) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port, "http")));
        return client;
    }

    public static void getResponseResult(SearchResponse response, String showField) {
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit searchHit : hits) {
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            System.out.println(sourceAsMap.get(showField));
        }
    }
}
