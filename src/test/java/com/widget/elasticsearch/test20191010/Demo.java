/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/10/10 7:50 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch.test20191010;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/10/10
 * @since 1.0.0
 */
public class Demo {


    @Test
    public void test() throws UnknownHostException {
        String clusterName = "zk_es_data";
        String index = "zk_metadata_search_v1";
//        String index = "zk_sug_user_info_v1";
        String ip = "10.10.1.6";
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(ip), 9300));
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(matchAllQueryBuilder).setSize(15000).get();
        getResponseResult(response, client);
    }

    public static void getResponseResult(SearchResponse response, TransportClient client){
//        String insertIndex = "zk_sug_user_info_20191010_bak";
//        String insertType = "zk_sug_user_info";
        String insertIndex = "zk_metadata_search_20191010_bak";
        String insertType = "zk_metadata_search";
        SearchHit[] hits = response.getHits().getHits();
        System.out.println("total hits:::" + response.getHits().getTotalHits());
        for(SearchHit searchHit : hits){
            System.out.println("------------------------------------------------------------------");
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            System.out.println("id : " + searchHit.getId());
            Set<String> keySet = sourceAsMap.keySet();
            for (String key : keySet) {
                System.out.println(key + " : " + sourceAsMap.get(key));
            }
            JSONObject jsonRecored = (JSONObject) JSONObject.toJSON(sourceAsMap);
            IndexResponse responseRecord = client.prepareIndex(insertIndex, insertType,searchHit.getId())
                    .setSource(jsonRecored, XContentType.JSON)
                    .get();
            System.out.println(responseRecord.status());
        }
    }

}
