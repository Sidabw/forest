/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ClientDemo
 * Author:   feiyi
 * Date:     2019/3/19 11:40 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.elasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/3/19
 * @since 1.0.0
 */
public class ClientDemo {

    public static final String clusterName = "elasticsearch";

    public static final String address = "localhost";

    public static final int port = 9300;

    public static final String indexName = "tianmao";

    public static final String indexType = "doc";

    /***
     * 程序执行入口
     */
    public static void main(String[] args) throws Exception {
        TransportClient client = getClient();
//        TransportClient client = getClient();
//        SearchResponse searchResponse = simpleTermQuery(client, "bank");
//        getResponseResult(searchResponse, "firstname");
        /*SearchResponse searchResponse = simpleMatchQuery(client, "customer");
        getResponseResult(searchResponse, "name");*/
        /*SearchResponse response = simpleRangeQuery(client, "bank");
        getResponseResult(response, "firstname");*/
        /*indexNewRecored(client);*/
//        delete(client);
//        update(client);
    }

    public static TransportClient getClient() throws UnknownHostException {
        return getClient(address, clusterName);
    }

    public static TransportClient getClient(String address, String clusterName) throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(address), port));
        return client;
    }

    public static void getResponseResult(SearchResponse response, String showField) {
        SearchHit[] hits = response.getHits().getHits();
//        System.out.println("total hits:::" + response.getHits().totalHits);
        for (SearchHit searchHit : hits) {
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            System.out.println(sourceAsMap.get(showField));
        }
    }

}
