/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/10/11 10:37 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch.rest;

import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * 〈一句话功能简述〉:
 * 〈https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-search.html〉
 *
 * @author feiyi
 * @create 2019/10/11
 * @since 1.0.0
 */
public class Demo {

    public static void main (String[] args) {
        System.out.println(111);
    }

    @Test
    public void test () throws IOException {
        String host = "10.10.1.6";
        int port = 8200;

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port, "http")));
        matchAllQuery(client);

    }

    public static void matchAllQuery(RestHighLevelClient client) throws IOException {
        //支持跨index查询
        SearchRequest searchRequest = new SearchRequest("dataplus-models-pmc-test*"); //index 哪张表
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        sourceBuilder.from(0);
        sourceBuilder.size(10000);
        searchRequest.source(sourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search.getHits().getTotalHits().value);


    }

}
